package myComponents.view;

import enums.notifikacija.MyNotification;
import gui.mainview.MainFrame;
import myComponents.Prezentacija;
import myComponents.Slide;
import observer.IObserver;
import ruNodeModel.RuNode;
import state.radSaSlotovima.SlotStateManager;
import state.rezimRada.StateManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrezentacijaView extends JPanel implements IObserver {
    private Prezentacija prezentacija;
    private boolean slideShow; //da li je u slideshow modu

    private StateManager stateManager;
    private SlotStateManager slotStateManager;

    private JLabel autorLbl;
    private JPanel previewPanel;
    private JPanel boxPanel;

//    private JPanel contentPanel;
    private JPanel paneBitan; //Pane koji se prikazuje kao edit mode prez view-a
    private JPanel slideShowPanel; //panel koji se prikazuje kao view mode prez view-a

    private JToolBar toolBar;

    public PrezentacijaView(Prezentacija prezentacija) {
        this.prezentacija = prezentacija;
        this.prezentacija.addObserver(this);
//        this.prezentacija.getParent().addObserver(this);

        stateManager = new StateManager();
        slotStateManager = new SlotStateManager();

        this.setLayout(new BorderLayout());

        autorLbl = new JLabel();
        previewPanel = new JPanel();
        boxPanel = new JPanel();
        slideShowPanel = new JPanel();
        slideShowPanel.setLayout(new CardLayout());

        makeMeAToolBar();

        editToolBarMode();

        BoxLayout boxLayout = new BoxLayout(boxPanel, BoxLayout.Y_AXIS);
        BoxLayout boxLayoutPreview = new BoxLayout(previewPanel, BoxLayout.Y_AXIS);
        boxPanel.setLayout(boxLayout);
        previewPanel.setLayout(boxLayoutPreview);

        prodjiKrozSlideView();
        paneBitan = makeMeAPaneBitan();
        add(toolBar, BorderLayout.NORTH);
        add(paneBitan, BorderLayout.CENTER);
        add(autorLbl, BorderLayout.SOUTH);
    }

    private void prodjiKrozSlideView() {
        for(RuNode dete : prezentacija.getChildren()) {
            if (dete instanceof Slide) {
                boxPanel.add(dete.getName(), (SlideView) (dete.getSubscribers().get(0)));
                boxPanel.add(Box.createVerticalStrut(20));
                SlideView previewSlideView = new SlideView((Slide) dete);
                previewSlideView.setPreferredSize(new Dimension(100, 85));
                previewSlideView.setMaximumSize(new Dimension(100, 85));
                previewPanel.add(dete.getName(), previewSlideView);
                previewPanel.add(Box.createVerticalStrut(10));
                slideShowPanel.add(new SlideView((Slide) dete));
            }
        }
        validate();
        repaint();
    }

    public void prebaciNaEdit() {
        this.remove(this.getSlideShowPanel());
        this.add(this.getPaneBitan(), BorderLayout.CENTER);
        this.repaint();
        this.validate();
    }

    public void makeMeASlideShowPane() {
        slideShowPanel.removeAll();
        for(int i = 0; i < this.getPrezentacija().getChildren().size(); i++) {
            SlideView slideView = new SlideView((Slide) this.getPrezentacija().getChildren().get(i));
            slideView.setFlag(slideShow);
            slideShowPanel.add(slideView);
        }
        this.remove(paneBitan);
        this.add(slideShowPanel, BorderLayout.CENTER);
    }

    private JPanel makeMeAPaneBitan() {
        JPanel panelBitan = new JPanel();
        panelBitan.setLayout(new BorderLayout());
        panelBitan.add(new JScrollPane(boxPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
        previewPanel.setPreferredSize(new Dimension(150, 100));
        panelBitan.add(new JScrollPane(previewPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.WEST);
        panelBitan.setSize(new Dimension(100, 100));
        return panelBitan;
    }

    private void makeMeAToolBar() {
        toolBar = new JToolBar();
        toolBar.setBackground(new Color(0x81BDD7));
        toolBar.setFloatable(false);
    }

    //ima dugme za slideShow
    public void editToolBarMode() {
        toolBar.removeAll();
        toolBar.revalidate();
        toolBar.add(MainFrame.getInstance().getActionManager().getAddSlotAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getDeleteSlotAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getSelectSlotAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getMoveSlotAction());
        toolBar.addSeparator();
        toolBar.add(MainFrame.getInstance().getActionManager().getColorAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getStrokeChangerAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getStrokeVrstaAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getTipSadrzajaSlotaAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getEditSlotAction());
        toolBar.addSeparator();
        toolBar.add(MainFrame.getInstance().getActionManager().getSlideShowModeAction());
        toolBar.repaint();
    }

    //ima dugme za prev, next i editMode
    public void viewToolBarMode() {
        toolBar.removeAll();
        toolBar.revalidate();
        toolBar.add(MainFrame.getInstance().getActionManager().getPrevBtnAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getEditModeAction());
        toolBar.add(MainFrame.getInstance().getActionManager().getNextBtnAction());
        toolBar.repaint();
    }

    public void startEditMode() {
        stateManager.setStateEdit();
    }

    public void startViewMode(){
        stateManager.setStateView();
    }

    public void changeState() {
        stateManager.getCurrent().changeState();
    }

    public void startAddSlotMode() {
        slotStateManager.setAddSlotState();
    }

    public void startDeleteSlotMode() {
        slotStateManager.setDeleteSlotState();
    }

    public void startSelectSlotMode() {
        slotStateManager.setSelectSlotState();
    }

    public void startMoveSlotMode() {
        slotStateManager.setMoveSlotState();
    }

    public void startVibeSlotMode() {
        slotStateManager.setVibeSlotState();
    }

    public void mousePressed(int x, int y, Slide slide, SlideView slideView) {
        slotStateManager.getCurrent().mousePressed(x, y, slide);
    }

    public void mouseDragged(int x, int y, Slide slide) {
        slotStateManager.getCurrent().mouseDragged(x, y, slide);
    }

    @Override
    public void updateObserver(Object notification) {
        if(notification instanceof MyNotification) {
            MyNotification mojaNotifikacija = (MyNotification) notification;
            switch (mojaNotifikacija.getEnumNotif()) {
                case DODAVANJE:
                    boxPanel.removeAll();
                    previewPanel.removeAll();
                    slideShowPanel.removeAll();
                    prodjiKrozSlideView();
//                    validate();
//                    repaint();
                    break;
                case BRISANJE:
                    if(mojaNotifikacija.getNotification() instanceof Slide) {
                        List<Component> zaBrisanje = new ArrayList<>();
                        for(int i = 0; i < boxPanel.getComponents().length; i++) {
                            if(boxPanel.getComponent(i) instanceof SlideView &&
                                    ((SlideView)boxPanel.getComponent(i)).getSlide().equals(mojaNotifikacija.getNotification()) ) {
                                zaBrisanje.add(boxPanel.getComponent(i));
                                //Da li treba ovo? Kad se brise slideview, uklanja se sa observera slide-a, tj. modela?
                                //((SlideView)boxPanel.getComponent(i)).getSlide().removeObserver((SlideView)boxPanel.getComponent(i));
                                boxPanel.remove(i);
                                previewPanel.remove(i);
                            }
                        }
                        for(int i = 0; i < zaBrisanje.size(); i++) {
                            slideShowPanel.remove(i);
                        }
                    }
                    break;
                case POSTAVLJANJE_AUTORA:
                    autorLbl.setText(mojaNotifikacija.getNotification().toString());
                    break;
                case POSTAVLJANJE_IMENA:
                    JTabbedPane jTabbedPane = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, this);
                    if(jTabbedPane != null) {
                        for(int i = 0; i < jTabbedPane.getTabCount(); i++) {
                            if(SwingUtilities.isDescendingFrom(this, jTabbedPane.getComponentAt(i))) {
                                jTabbedPane.setTitleAt(i, ((MyNotification) notification).getNotification().toString());
                                break;
                            }
                        }

                    }
                    break;
                default:
                    break;
            }
            validate();
            repaint();
        }
        prezentacija.setChanged(true);
    }

    public boolean isSlideShow() {
        return slideShow;
    }

    public void setSlideShow(boolean slideShow) {
        this.slideShow = slideShow;
        for(int i = 0; i < boxPanel.getComponents().length; i++) {
            if(boxPanel.getComponent(i) instanceof SlideView){
                ((SlideView)boxPanel.getComponent(i)).setFlag(slideShow);
            }
        }
    }

    public Prezentacija getPrezentacija() {
        return prezentacija;
    }

    public void setPrezentacija(Prezentacija prezentacija) {
        this.prezentacija = prezentacija;
    }

    public JPanel getSlideShowPanel() {
        return slideShowPanel;
    }

    public JLabel getAutorLbl() {
        return autorLbl;
    }

    public void setAutorLbl(JLabel autorLbl) {
        this.autorLbl.setText("Autor: " + autorLbl.getText());
    }

    public JPanel getPaneBitan() {
        return paneBitan;
    }

    public void setPaneBitan(JPanel paneBitan) {
        this.paneBitan = paneBitan;
    }

    public JPanel getBoxPanel() {
        return boxPanel;
    }

    public void setBoxPanel(JPanel boxPanel) {
        this.boxPanel = boxPanel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrezentacijaView that = (PrezentacijaView) o;
        return Objects.equals(prezentacija, that.prezentacija);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prezentacija);
    }
}
