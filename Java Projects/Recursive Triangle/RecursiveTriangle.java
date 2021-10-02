/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adameinstein
 */
import java.awt.*;
import javax.swing.*;

public class Homework4 extends Canvas
{
    
    public static void main(String[] args) {
        JFrame canvas = new JFrame("Triangle");
        canvas.setSize(800, 800);//set canvas size to 800 pixels
        Homework4 canvasT = new Homework4();
        canvas.add(canvasT); 
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//program finishes when frame closes
        canvas.setBackground(Color.BLACK);//set background to black
        canvas.setVisible(true);
    }
    
    @Override
    public void paint(Graphics graph) {//initialize graphics
        drawIt(graph);
    }
    
    public void drawIt(Graphics graph) {//initialize triangle canvas
        triangleDraw(0,0, 800, graph);
    }
    
    public void triangleDraw(int x, int y, int side, Graphics graph) {//recursively draw triangles
        int len = side / 2;
        int[] xP = {x, x+len, x+side};// x point for triangle
        int[] yP = {y+side, y, y+side};// y point for triangle
        graph.setColor(Color.BLACK);
        graph.fillPolygon(xP,yP,3); //fill in first right side up triangle
        int[] upsideX = {x+side/4, x+side/2, x+(side/4)*3}; //x point for upside down triangle
        int[] upsideY = {y+side/2, y + side, y+side/2}; //y point for upside down triangle
        graph.setColor(Color.WHITE);
        graph.fillPolygon(upsideX, upsideY, 3); // fill in upside down triangle
        if(len >= 2) { //repeat until pixel length of side is 2
            triangleDraw(x,y+len,len,graph); // draw left side triangle
            triangleDraw(x+side/4,y,side/2,graph); //draw middle triangle
            triangleDraw(x+len,y+len,len,graph); //draw upsdie down triangle
        }
    }
    
}

    

