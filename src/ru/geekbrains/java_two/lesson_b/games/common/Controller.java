package ru.geekbrains.java_two.lesson_b.games.common;

import java.awt.*;

public interface Controller {
    void onDrawCanvas(GameCanvas c, Graphics g, float deltaTime);
}
