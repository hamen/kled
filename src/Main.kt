import purejavahidapi.HidDeviceInfo
import purejavahidapi.PureJavaHidApi

fun main(args: Array<String>) {

    try {
        var devInfo: HidDeviceInfo? = getDevice()
        if (devInfo == null) {
            println("Device not found. Supported device are: ")
            println("VENDORID: 0x1294 - PRODUCTID: 0x1320 http://www.dx.com/p/usb-universal-e-mail-webmail-im-notifier-gmail-outlook-outlook-express-pop3-27062#.Vkw0at-rTo0")
        } else {
            val data: ByteArray

            if (args.size == 0 || (args.size == 1 && args[0] == "--help")) {
                println("Use one of these colors as first argument:")
                println("off, blue, red, green, liteblue, purple, yellow, white")
                data = byteArrayOf(Colors.OFF.second.toByte())
            } else {
                val color = Colors.colors.get(args[0].toLowerCase()) ?: 0
                data = byteArrayOf(color.toByte())
            }

            setLedColor(data, devInfo)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private fun getDevice(): HidDeviceInfo? {
    val devList = PureJavaHidApi.enumerateDevices()
    var devInfo: HidDeviceInfo? = null
    for (info in devList) {
        if (info.vendorId == 0x1294.toShort() && info.productId == 0x1320.toShort()) {
            devInfo = info
            break
        }
    }
    return devInfo
}

private fun setLedColor(data: ByteArray, devInfo: HidDeviceInfo) {
    val dev = PureJavaHidApi.openDevice(devInfo.path)
    dev.setOutputReport(0.toByte(), data, data.size)
    dev.close()
}