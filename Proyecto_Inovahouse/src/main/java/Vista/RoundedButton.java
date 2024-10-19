/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {

    private int borderRadius;

    public RoundedButton(String text, int borderRadius) {
        super(text);
        this.borderRadius = borderRadius;
        setContentAreaFilled(false); // Evita que se dibuje el fondo por defecto
        setFocusPainted(false); // Evita que se dibuje el borde de enfoque
        setOpaque(false); // Evita que el botón se dibuje opaco
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), borderRadius, borderRadius));
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Si deseas un borde, lo puedes dibujar aquí
        super.paintBorder(g);
    }
}

