import java.awt.*;
import javax.swing.*;

public class ModePage extends JPanel{
    ModePage(){
        initComponents();
    }

    private void initComponents() {
        setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 0, 50));
        setPreferredSize(new Dimension(1280, 720));
        
        JLabel label= new JLabel("Other page");

        add(label);

    
    }
}
