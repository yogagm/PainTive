/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.mavenproject1;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DiamondFigure;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.EllipseFigure;
import org.jhotdraw.draw.RectangleFigure;
import org.jhotdraw.draw.TextFigure;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.draw.io.ImageOutputFormat;
import org.jhotdraw.draw.io.SerializationInputOutputFormat;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.draw.tool.DnDTracker;
import org.jhotdraw.draw.tool.SelectionTool;
import org.jhotdraw.util.ResourceBundleUtil;

/*class DelegationSelectionTool extends CustomSelectionTool{
    private TextTool textTool;
    
    public DelegationSelectionTool(DrawingView view){
        super(view);
        textTool = new TextTool();
    }
    
    protected void handleMouseDoubleClick(MouseEvent e, int x, int y){
        Figure figure = drawing().findFigureInside(e.getX(), e.getY());
        if ((figure!=null)&&(figure instanceof TextFigure)){
            textTool.active();
            textTool.mouseDown(e,x,y);
        }
    }
    
    protected void handleMouseClick(MouseEvent e, int x, int y){
        deactivate();
    }
    
    public void deactivate(){
        deactivate();
        if(textTool.isActivate())
             textTool.deactivate();
    }
}*/

public class jhotdrawapp {
       
    public static void main(String[] args) {
        
        
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                
                DrawingView view1 = new DefaultDrawingView();
                view1.setDrawing(createDrawing());
                
                DrawingView view2 = new DefaultDrawingView();
                view2.setDrawing(createDrawing());

                DrawingEditor editor = new DefaultDrawingEditor();
                editor.add(view1);
                DrawingEditor editor2 = new DefaultDrawingEditor();
                editor2.add(view2);
                
                JToolBar tb = new JToolBar();
                SelectionTool selectionTool = new SelectionTool();
                selectionTool.setDragTracker(new DnDTracker());
                ButtonFactory.addSelectionToolTo(tb, editor, selectionTool);
                ButtonFactory.addToolTo(
                tb, editor,
                new CreationTool(new RectangleFigure()),
                "edit.createRectangle",
                labels);
                
                SelectionTool selectionTool2 = new SelectionTool();
                selectionTool2.setDragTracker(new DnDTracker());
                ButtonFactory.addToolTo(
                tb, editor,
                new CreationTool(new EllipseFigure()),
                "edit.createEllipse",
                labels);
                
                SelectionTool selectionTool3 = new SelectionTool();
                selectionTool3.setDragTracker(new DnDTracker());
                ButtonFactory.addToolTo(
                tb, editor,
                new CreationTool(new DiamondFigure()),
                "edit.createDiamond",
                labels);
                
                SelectionTool selectionTool4 = new SelectionTool();
                selectionTool4.setDragTracker(new DnDTracker());
                ButtonFactory.addToolTo(
                tb, editor,
                new CreationTool(new TextFigure()),
                "edit.createText",
                labels);
                
                tb.setOrientation(JToolBar.VERTICAL);
                
                JFrame f = new JFrame("Multi-Editor");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(400, 300);
                
                JPanel innerPane = new JPanel();
                innerPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
                JScrollPane sp;
                JScrollPane sp2;
                innerPane.add(sp = new JScrollPane(view1.getComponent()));
                innerPane.add(sp2 = new JScrollPane(view2.getComponent()));
                sp.setPreferredSize(new Dimension(500,500));
                sp2.setPreferredSize(new Dimension(500,500));
                f.getContentPane().add(new JScrollPane(innerPane));
                f.getContentPane().add(tb, BorderLayout.WEST);
                f.setVisible(true);
                
            }
        });
    }
/**
* Creates a drawing with input and output formats, so that drawing figures
* can be copied and pasted between drawing views.
*
* @return a drawing
*/
        private static Drawing createDrawing() {
        // Create a default drawing with
        // input/output formats for basic clipboard support.
        DefaultDrawing drawing = new DefaultDrawing();
        drawing.addInputFormat(new SerializationInputOutputFormat());
        drawing.addOutputFormat(new SerializationInputOutputFormat());
        drawing.addOutputFormat(new ImageOutputFormat());
        return drawing;

        }
}
    
