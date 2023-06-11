/**
 * 项目名：kotlin-learning
 * 包名：
 * 文件名：Lesson1.kt
 * 创建时间：2022/12/17-16:29
 *
 * @author jacky.li
 * 描述：
 */
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun log(msg: String) {
    println(msg + ", threadId:${Thread.currentThread().id}, threadName:${Thread.currentThread().name}")
}

fun ex01() {
    GlobalScope.launch(context = Dispatchers.IO) {
        delay(500) // 挂起
        log("launch1")
    }
    GlobalScope.launch(context = Dispatchers.IO) {
        delay(1000) // 挂起
        log("launch2")
    }
    // 主动休眠(阻塞)两秒，防止 JVM 过快退出
    Thread.sleep(2000)
    log("end")
}

fun main() {
    ex01()
}