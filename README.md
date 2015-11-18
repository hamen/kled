# KLED

This is a Kotlin CLI tool to control [DealExtreme USB Universal E-mail/Webmail/IM Notifier](http://www.dx.com/p/usb-universal-e-mail-webmail-im-notifier-gmail-outlook-outlook-express-pop3-27062#.Vkw0at-rTo0) (SKU: 27062)

It's based on [PureJavaHIDApi](https://github.com/nyholku/purejavahidapi) for the communication part and on [usbnotifierosx_cli](https://github.com/bettse/usbnotifierosx_cli) for the color codes.

## Usage

In a Terminal, run

```
java -jar kled.jar
```

to get the help and the colors list or

```
java -jar kled.jar red
```

to set the light to a known color.

## License
My 50 lines of code are licensed under Apache2, but you should check out the dependencies to be sure there is no multi-license exotic pitfall.