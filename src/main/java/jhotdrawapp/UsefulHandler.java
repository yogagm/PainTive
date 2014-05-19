/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jhotdrawapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import org.jhotdraw.draw.AttributeKey;
import static org.jhotdraw.draw.AttributeKeys.FILL_COLOR;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DiamondFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.EllipseFigure;
import org.jhotdraw.draw.LineFigure;
import org.jhotdraw.draw.RectangleFigure;
import org.jhotdraw.draw.RoundRectangleFigure;
import org.jhotdraw.draw.TextAreaFigure;
import org.jhotdraw.draw.TextFigure;
import org.jhotdraw.draw.TriangleFigure;
import org.jhotdraw.draw.action.ButtonFactory;
import org.jhotdraw.draw.action.ColorIcon;
import org.jhotdraw.draw.io.SerializationInputOutputFormat;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 *
 * @author Yogayustiawan
 */
final class UsefulHandler {
    
    private static final int MAROON = 0x800000;
    private static final int WHITE = 0xFFFFFF;
    private static final int RED = 0xFF0000;
    private static final int LIME = 0x00FF00;
    private static final int BLUE = 0x0000FF;
    private static final int YELLOW = 0xFFFF00;
    private static final int CYAN = 0x00FFFF;
    private static final int MAGENTA = 0xFF00FF;
    private static final int SILVER = 0xC0C0C0;
    private static final int GRAY = 0x808080;
    private static final int BLACK = 0x000000;
    private static final int GREEN = 0x808000;
    private static final int PURPLE = 0x800080;
    private static final int TEAL = 0x008080;
    private static final int NAVY = 0x000080;

    public static final java.util.List<ColorIcon> DEFAULT_COLORS;

    private static final int BC = 12;
    private static final int HEIGHT = 640;
    private static final int WIDTH = 480;
    private static final int X = 200;
    private static final int Y = 200;
    
        static {
        //membuat list warna
        List<ColorIcon> c = new LinkedList<ColorIcon>();
        c.add(new ColorIcon(MAROON, "Maroon"));
        c.add(new ColorIcon(WHITE, "White"));
        c.add(new ColorIcon(RED, "Red"));
        c.add(new ColorIcon(LIME, "Lime"));
        c.add(new ColorIcon(BLUE, "Blue"));
        c.add(new ColorIcon(YELLOW, "Yellow"));
        c.add(new ColorIcon(CYAN, "Cyan"));
        c.add(new ColorIcon(MAGENTA, "Magenta"));
        c.add(new ColorIcon(SILVER, "Silver"));
        c.add(new ColorIcon(GRAY, "Gray"));
        c.add(new ColorIcon(BLACK, "Black"));
        c.add(new ColorIcon(GREEN, "Green"));
        c.add(new ColorIcon(PURPLE, "Purple"));
        c.add(new ColorIcon(TEAL, "Teal"));
        c.add(new ColorIcon(NAVY, "Navy"));
        DEFAULT_COLORS = Collections.unmodifiableList(c);
    }
    static {
        //untuk membuat label
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

        // Create a drawing view with a default drawing, and
        // input/output formats for basic clipboard support.
        DrawingView view = new DefaultDrawingView();

        //Membuat editor
        DefaultDrawing drawing = new DefaultDrawing();

        //membuat fungsi input tools
        drawing.addInputFormat(new SerializationInputOutputFormat());

        //membuat fungsi output tools
        drawing.addOutputFormat(new SerializationInputOutputFormat());

        //menampilkan editor
        view.setDrawing(drawing);

        // Create a common drawing editor for the views
        DrawingEditor editor = new DefaultDrawingEditor();
        editor.add(view);

        // Create a tool bar
        JToolBar tb = new JToolBar();

        // Add a selection tool to the toolbar.
        ButtonFactory.addSelectionToolTo(tb, editor);

        // Add a creation tool for rectangles to the toolbar.
        Map<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        //memberi warna putih pada objek a
        FILL_COLOR.put(a, Color.WHITE);
        //memberi tools pada editor
        ButtonFactory.addToolTo(
                tb, editor,
                new CreationTool(new RectangleFigure(), a),
                "edit.createRectangle",
                labels);
        //meletakkan tools pada posisi vertical
        tb.setOrientation(JToolBar.VERTICAL);

        // Add a creation tool for ellipse to the toolbar.
        Map<AttributeKey, Object> b = new HashMap<AttributeKey, Object>();
        //memberi warna putih pada objek b
        FILL_COLOR.put(b, Color.WHITE);
        //memberi tools pada editor
        ButtonFactory.addToolTo(
                tb, editor,
                new CreationTool(new EllipseFigure(), b),
                "edit.createEllipse",
                labels);
        //meletakkan tools pada posisi vertical
        tb.setOrientation(JToolBar.VERTICAL);

        // Add a creation tool for straight line to the toolbar.
        Map<AttributeKey, Object> c = new HashMap<AttributeKey, Object>();
        //memberi warna putih pada objek c
        FILL_COLOR.put(c, Color.WHITE);
        //memberi tools pada editor
        ButtonFactory.addToolTo(
                tb, editor,
                new CreationTool(new LineFigure(), c),
                "edit.createLine",
                labels);
        //meletakkan tools pada posisi vertical
        tb.setOrientation(JToolBar.VERTICAL);

        // Add a creation tool for text area to the toolbar.
        Map<AttributeKey, Object> d = new HashMap<AttributeKey, Object>();
        //memberi warna putih pada objek d
        FILL_COLOR.put(d, Color.RED);
        //memberi tools pada editor
        ButtonFactory.addToolTo(
                tb, editor,
                new CreationTool(new TextAreaFigure(), d),
                "edit.createTextArea",
                labels);
        //meletakkan tools pada posisi vertical
        tb.setOrientation(JToolBar.VERTICAL);

        // Add a creation tool for diamond to the toolbar.
        Map<AttributeKey, Object> e = new HashMap<AttributeKey, Object>();
        //memberi warna putih pada objek e
        FILL_COLOR.put(e, Color.WHITE);
        //memberi tools pada editor
        ButtonFactory.addToolTo(
                tb, editor,
                new CreationTool(new DiamondFigure(), e),
                "edit.createDiamond",
                labels);
        //meletakkan tools pada posisi vertical
        tb.setOrientation(JToolBar.VERTICAL);

        // Add a creation tool for round rectangle to the toolbar.
        Map<AttributeKey, Object> g = new HashMap<AttributeKey, Object>();
        //memberi warna putih pada objek g
        FILL_COLOR.put(g, Color.WHITE);
        //memberi tools pada editor
        ButtonFactory.addToolTo(
                tb, editor,
                new CreationTool(new RoundRectangleFigure(), g),
                "edit.createRoundRectangle",
                labels);
        //meletakkan tools pada posisi vertical
        tb.setOrientation(JToolBar.VERTICAL);

        // Add a creation tool for triangle to the toolbar.
        Map<AttributeKey, Object> h = new HashMap<AttributeKey, Object>();
        //memberi warna putih pada objek h
        FILL_COLOR.put(h, Color.WHITE);
        //memberi tools pada editor
        ButtonFactory.addToolTo(
                tb, editor,
                new CreationTool(new TriangleFigure(), h),
                "edit.createTriangle",
                labels);
        //meletakkan tools pada posisi vertical
        tb.setOrientation(JToolBar.VERTICAL);

        // Add a creation tool for triangle to the toolbar.
        Map<AttributeKey, Object> i = new HashMap<AttributeKey, Object>();
        //memberi warna putih pada objek i
        FILL_COLOR.put(i, Color.WHITE);
        //memberi tools pada editor
        ButtonFactory.addToolTo(
                tb, editor,
                new CreationTool(new TextFigure(), i),
                "edit.createText",
                labels);
        //meletakkan tools pada posisi vertical
        tb.setOrientation(JToolBar.VERTICAL);

        // Add a color button
        ButtonFactory.addColorButtonsTo(tb, editor, DEFAULT_COLORS, BC);
                
        // Put all together into a JFrame
        JFrame f = new JFrame("PainTive");
        //menge-set operasi close
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //menge-set ukuran frame
        f.setSize(HEIGHT, WIDTH);

        // Set up the content pane
        // Place the toolbar on the left
        f.getContentPane().add(tb, BorderLayout.WEST);
        // Place the drawing view inside a scroll pane in the center
        JScrollPane sp = new JScrollPane(view.getComponent());
        //menge-set size
        sp.setPreferredSize(new Dimension(X, Y));
        //menge-set letak layout agar berada di tengah
        f.getContentPane().add(sp, BorderLayout.CENTER);

        //To change body of generated methods, choose Tools | Templates.
        f.setVisible(true);
    }    
}
