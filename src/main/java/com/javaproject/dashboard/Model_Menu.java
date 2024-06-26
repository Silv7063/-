package com.javaproject.dashboard;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Model_Menu {

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
        this.font = new Font("SansSerif", Font.PLAIN, 16);
    }

    public Model_Menu() {
    }

    private String icon;
    private String name;
    private MenuType type;
    private Font font;

    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/" + icon + ".png"));
    }

    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
}
