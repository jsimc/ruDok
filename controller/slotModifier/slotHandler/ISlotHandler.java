package controller.slotModifier.slotHandler;

import contents.Content;

import java.awt.*;

public interface ISlotHandler {
    Content readContent(Object arg);
    void writeContent(Content content);
    void paint(Graphics2D g);
}
