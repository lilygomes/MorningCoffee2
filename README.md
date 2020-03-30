##MorningCoffee 2
*An awful desktop environment for awful people.*
###The Applications menu is empty!
That's because you need to add your applications to the menu by modifying the `applications` file in the `mc2` folder.
On first run, MC2 will generate the `mc2/` folder in the location of the JAR file you're running from, or in the root of the source code project in your IDE.
To add an item to your menu, add a line in this format:
```
Name;Command
```
Do not add any extra spaces with any of the interpreted symbols, as trailing whitespace will not be removed.
To add a submenu, use this format:
```
Submenu name;{
Item name;Command
Item name;Command
}
```
For instance:
```
Internet;{
Discord Canary;/usr/bin/discord-canary
Firefox;/usr/bin/firefox
}
Tilix;/usr/bin/tilix
```
This creates a Internet submenu with the items Discord Canary and Firefox in it, but Tilix is not in the submenu, and is in the main menu.