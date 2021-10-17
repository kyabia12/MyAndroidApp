package com.greengoat3.android.mydesignpatternapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractFactory
import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractLink
import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractPage
import com.greengoat3.android.mydesignpatternapp.abstractFactory.factory.AbstractTray
import com.greengoat3.android.mydesignpatternapp.adapter.inst.PrintBanner
import com.greengoat3.android.mydesignpatternapp.bridge.CountDisplay
import com.greengoat3.android.mydesignpatternapp.bridge.Display
import com.greengoat3.android.mydesignpatternapp.bridge.StringDisplayImpl
import com.greengoat3.android.mydesignpatternapp.builder.Director
import com.greengoat3.android.mydesignpatternapp.builder.TextBuilder
import com.greengoat3.android.mydesignpatternapp.composite.Directory
import com.greengoat3.android.mydesignpatternapp.composite.File
import com.greengoat3.android.mydesignpatternapp.composite.FileTreatmentException
import com.greengoat3.android.mydesignpatternapp.factory.pc.PcFactory
import com.greengoat3.android.mydesignpatternapp.iterator.book.Book
import com.greengoat3.android.mydesignpatternapp.iterator.book.BookShelf
import com.greengoat3.android.mydesignpatternapp.prototype.Manager
import com.greengoat3.android.mydesignpatternapp.prototype.MessageBox
import com.greengoat3.android.mydesignpatternapp.prototype.Product
import com.greengoat3.android.mydesignpatternapp.prototype.UnderlinePen
import com.greengoat3.android.mydesignpatternapp.singleton.Singleton
import com.greengoat3.android.mydesignpatternapp.strategy.Player
import com.greengoat3.android.mydesignpatternapp.strategy.ProbStrategy
import com.greengoat3.android.mydesignpatternapp.strategy.WinnerStrategy
import com.greengoat3.android.mydesignpatternapp.templatemehod.AbstractDisplay
import com.greengoat3.android.mydesignpatternapp.templatemehod.CharDisplay
import com.greengoat3.android.mydesignpatternapp.templatemehod.StringDisplay

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val factory = PcFactory()

        val pc1 = factory.create("A001")
        val pc2 = factory.create("A002")
        val pc3 = factory.create("A003")

        pc1.use()
        pc2.use()
        pc3.use()

        val bookShelf = BookShelf()
        bookShelf.appendBook(Book("Around the world in 80 days"))
        bookShelf.appendBook(Book("Bible"))
        bookShelf.appendBook(Book("Cinderella"))
        bookShelf.appendBook(Book("Daddy-Long-Legs"))

        val it = bookShelf.iterator()
        while (it.hasNext()) {
            val book = it.next() as Book
            Log.i("book", book.getName())
        }

        val p = PrintBanner("Hello")
        p.printWeak()
        p.printString()

//        val d1:AbstractDisplay = CharDisplay('H')
//        val d2:AbstractDisplay = StringDisplay("Hello, world")
//        val d3:AbstractDisplay = StringDisplay("こんにちは。")
//
//        d1.display()
//        d2.display()
//        d3.display()

        val obj1 = Singleton.getInstance()
        val obj2 = Singleton.getInstance()

        if (obj1 ==obj2) {
            Log.i("MainActivity", "obj1とobj2は同じインスタンスです。")
        } else {
            Log.i("MainActivity", "obj1とobj2は同じインスタンスではありません。")
        }

        val manager = Manager()
        val upen = UnderlinePen('-')
        val mbox = MessageBox('*')
        val sbox = MessageBox('/')
        manager.register("strong message", upen)
        manager.register("warning box", mbox)
        manager.register("slash box", sbox)

        val p1:Product = manager.create("strong message")
        p1.use("Hello, world")
        val p2:Product = manager.create("warning box")
        p2.use("Hello, world")
        val p3:Product = manager.create("slash box")
        p3.use("Hello, world")

        val textbuilder = TextBuilder()
        val director = Director(textbuilder)
        director.construct()
        val result = textbuilder.getResult()
        Log.i("MainActivity", result)

        AbstractFactory.getFactory("com.greengoat3.android.mydesignpatternapp.abstractFactory.listfactory.ListFactory")?.let {
            val aa: AbstractLink = it.createLink("aa新聞", "test")
            val bb: AbstractLink = it.createLink("bb新聞", "TEST")

            val tray: AbstractTray = it.createTray("caption")
            tray.add(aa)
            tray.add(bb)

            val page: AbstractPage = it.createPage("title", "author")
            page.add(tray)
            page.output()
        }

        val d1 = Display(StringDisplayImpl("Hello"))
        val d2 = CountDisplay(StringDisplayImpl("TEST"))
        d1.display()
        d2.multiDisplay(2)

        val player1 = Player("taro",WinnerStrategy())
        val player2 = Player("hanako", ProbStrategy())

        for (i in 0..100) {
            val nextHand1 = player1.nextHand()
            val nextHand2 = player2.nextHand()

            when {
                nextHand1.isStrongerThan(nextHand2) -> {
                    player1.win()
                    player2.lose()
                }
                nextHand2.isStrongerThan(nextHand1) -> {
                    player1.lose()
                    player2.win()
                }
                else -> {
                    player1.even()
                    player2.even()
                }
            }
        }
        Log.i("MainActivity", player1.toString())
        Log.i("MainActivity", player2.toString())

        try {
            val rootDir = Directory("root")
            val binDir = Directory("bin")
            val tmpDir = Directory("tmp")
            rootDir.add(binDir)
            binDir.add(tmpDir)
            binDir.add(File("vi", 1000))
            rootDir.printList()
        } catch (e: FileTreatmentException) {
            Log.e("MainActivity", e.toString())
        }

    }
}