import org.junit.Test

import org.junit.Assert.*
import ru.netology.calculatePayTransfer

class MainKtTest {

    @Test
    fun calculatePayTransfer() {

        val result = calculatePayTransfer(1000, 75000, 2000, "Maestro")

        assertEquals(26, result)

    }

    @Test
    fun calculatePayTransferMasterCard() {

        val result = calculatePayTransfer(1000, 75000, 151000, "MasterCard")

        assertEquals(-1000, result)

    }

    @Test
    fun calculatePayTransferVisa() {

        val result = calculatePayTransfer(1000, 75000, 151000, "Visa")

        assertEquals(-1000, result)

    }

    @Test
    fun calculatePayTransferMIR() {

        val result = calculatePayTransfer(1000, 75000, 151000, "MIR")

        assertEquals(-1000, result)

    }

    @Test
    fun calculatePayTransferVKPay() {

        val result = calculatePayTransfer(1000, 41000, 151000, "VKPay")

        assertEquals(-1000, result)

    }

    @Test
    fun calculatePayTransferElse() {

        val result = calculatePayTransfer(1000, 75000, 151000, "Ma")

        assertEquals(-75000, result)

    }
}