package ru.geekbrains.java_two.lesson_b.games.common;

import java.awt.*;

public interface CommonObject {
    void update(GameCanvas canvas, float deltaTime);
    void render(GameCanvas canvas, Graphics g);
}
