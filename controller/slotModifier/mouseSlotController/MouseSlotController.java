package controller.slotModifier.mouseSlotController;

import gui.mainview.MainFrame;
import myComponents.Slide;
import myComponents.view.PrezentacijaView;
import myComponents.view.SlideView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseSlotController extends MouseAdapter {
    private SlideView slideView;
    private Slide slide;

    public MouseSlotController(SlideView slideView) {
        this.slideView = slideView;
        this.slideView.addMouseListener(this);
        this.slideView.addMouseMotionListener(this);
        this.slide = slideView.getSlide();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1){
            PrezentacijaView focusedPrezView = (PrezentacijaView) MainFrame.getInstance().getProjekatView()
                    .getPrezentacijeTabbedPane().getSelectedComponent();

            focusedPrezView.mousePressed(e.getX(), e.getY(), slide, slideView);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        PrezentacijaView focusedPrezView = (PrezentacijaView) MainFrame.getInstance().getProjekatView()
                .getPrezentacijeTabbedPane().getSelectedComponent();

        focusedPrezView.mouseDragged(e.getX(), e.getY(), slide);
    }

}
