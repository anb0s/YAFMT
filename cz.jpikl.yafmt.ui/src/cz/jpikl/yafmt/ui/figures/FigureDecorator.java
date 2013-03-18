package cz.jpikl.yafmt.ui.figures;

import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.CoordinateListener;
import org.eclipse.draw2d.EventDispatcher;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IClippingStrategy;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.KeyEvent;
import org.eclipse.draw2d.KeyListener;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;


public class FigureDecorator implements IFigure {

    protected IFigure decoratedFigure;
    
    public FigureDecorator(IFigure decoratedFigure) {
        this.decoratedFigure = decoratedFigure;
    }

    @Override
    public void add(IFigure figure) {
        decoratedFigure.add(figure);
    }

    @Override
    public void add(IFigure figure, int index) {
        decoratedFigure.add(figure, index);
    }

    @Override
    public void add(IFigure figure, Object constraint) {
        decoratedFigure.add(figure, constraint);
    }

    @Override
    public void add(IFigure figure, Object constraint, int index) {
        decoratedFigure.add(figure, constraint, index);
    }

    @Override
    public void addAncestorListener(AncestorListener listener) {
        decoratedFigure.addAncestorListener(listener);
    }

    @Override
    public void addCoordinateListener(CoordinateListener listener) {
        decoratedFigure.addCoordinateListener(listener);
    }

    @Override
    public void addFigureListener(FigureListener listener) {
        decoratedFigure.addFigureListener(listener);
    }

    @Override
    public void addFocusListener(FocusListener listener) {
        decoratedFigure.addFocusListener(listener);
    }

    @Override
    public void addKeyListener(KeyListener listener) {
        decoratedFigure.addKeyListener(listener);
    }

    @Override
    public void addLayoutListener(LayoutListener listener) {
        decoratedFigure.addLayoutListener(listener);
    }

    @Override
    public void addMouseListener(MouseListener listener) {
        decoratedFigure.addMouseListener(listener);
    }

    @Override
    public void addMouseMotionListener(MouseMotionListener listener) {
        decoratedFigure.addMouseMotionListener(listener);
    }

    @Override
    public void addNotify() {
        decoratedFigure.addNotify();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        decoratedFigure.addPropertyChangeListener(listener);
    }

    @Override
    public void addPropertyChangeListener(String property, PropertyChangeListener listener) {
        decoratedFigure.addPropertyChangeListener(property, listener);
    }

    @Override
    public boolean containsPoint(int x, int y) {
        return decoratedFigure.containsPoint(x, y);
    }

    @Override
    public boolean containsPoint(Point p) {
        return decoratedFigure.containsPoint(p);
    }

    @Override
    public void erase() {
        decoratedFigure.erase();
    }

    @Override
    public IFigure findFigureAt(int x, int y) {
        return decoratedFigure.findFigureAt(x, y);
    }

    @Override
    public IFigure findFigureAt(int x, int y, TreeSearch search) {
        return decoratedFigure.findFigureAt(x, y, search);
    }

    @Override
    public IFigure findFigureAt(Point p) {
        return decoratedFigure.findFigureAt(p);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public IFigure findFigureAtExcluding(int x, int y, Collection collection) {
        return decoratedFigure.findFigureAtExcluding(x, y, collection);
    }

    @Override
    public IFigure findMouseEventTargetAt(int x, int y) {
        return decoratedFigure.findMouseEventTargetAt(x, y);
    }

    @Override
    public Color getBackgroundColor() {
        return decoratedFigure.getBackgroundColor();
    }

    @Override
    public Border getBorder() {
        return decoratedFigure.getBorder();
    }

    @Override
    public Rectangle getBounds() {
        return decoratedFigure.getBounds();
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List getChildren() {
        return decoratedFigure.getChildren();
    }

    @Override
    public Rectangle getClientArea() {
        return decoratedFigure.getClientArea();
    }

    @Override
    public Rectangle getClientArea(Rectangle rect) {
        return decoratedFigure.getClientArea(rect);
    }

    @Override
    public IClippingStrategy getClippingStrategy() {
        return decoratedFigure.getClippingStrategy();
    }

    @Override
    public Cursor getCursor() {
        return decoratedFigure.getCursor();
    }

    @Override
    public Font getFont() {
        return decoratedFigure.getFont();
    }

    @Override
    public Color getForegroundColor() {
        return decoratedFigure.getForegroundColor();
    }

    @Override
    public Insets getInsets() {
        return decoratedFigure.getInsets();
    }

    @Override
    public LayoutManager getLayoutManager() {
        return decoratedFigure.getLayoutManager();
    }

    @Override
    public Color getLocalBackgroundColor() {
        return decoratedFigure.getLocalBackgroundColor();
    }

    @Override
    public Color getLocalForegroundColor() {
        return decoratedFigure.getLocalForegroundColor();
    }

    @Override
    public Dimension getMaximumSize() {
        return decoratedFigure.getMaximumSize();
    }

    @Override
    public Dimension getMinimumSize() {
        return decoratedFigure.getMinimumSize();
    }

    @Override
    public Dimension getMinimumSize(int wHint, int hHint) {
        return decoratedFigure.getMinimumSize(wHint, hHint);
    }

    @Override
    public IFigure getParent() {
        return decoratedFigure.getParent();
    }

    @Override
    public Dimension getPreferredSize() {
        return decoratedFigure.getPreferredSize();
    }

    @Override
    public Dimension getPreferredSize(int wHint, int hHint) {
        return decoratedFigure.getPreferredSize(wHint, hHint);
    }

    @Override
    public Dimension getSize() {
        return decoratedFigure.getSize();
    }

    @Override
    public IFigure getToolTip() {
        return decoratedFigure.getToolTip();
    }

    @Override
    public UpdateManager getUpdateManager() {
        return decoratedFigure.getUpdateManager();
    }

    @Override
    public void handleFocusGained(FocusEvent event) {
        decoratedFigure.handleFocusGained(event);
    }

    @Override
    public void handleFocusLost(FocusEvent event) {
        decoratedFigure.handleFocusLost(event);
    }

    @Override
    public void handleKeyPressed(KeyEvent event) {
        decoratedFigure.handleKeyPressed(event);
    }

    @Override
    public void handleKeyReleased(KeyEvent event) {
        decoratedFigure.handleKeyReleased(event);
    }

    @Override
    public void handleMouseDoubleClicked(MouseEvent event) {
        decoratedFigure.handleMouseDoubleClicked(event);
    }

    @Override
    public void handleMouseDragged(MouseEvent event) {
        decoratedFigure.handleMouseDragged(event);
    }

    @Override
    public void handleMouseEntered(MouseEvent event) {
        decoratedFigure.handleMouseEntered(event);
    }

    @Override
    public void handleMouseExited(MouseEvent event) {
        decoratedFigure.handleMouseExited(event);
    }

    @Override
    public void handleMouseHover(MouseEvent event) {
        decoratedFigure.handleMouseHover(event);
    }

    @Override
    public void handleMouseMoved(MouseEvent event) {
        decoratedFigure.handleMouseMoved(event);
    }

    @Override
    public void handleMousePressed(MouseEvent event) {
        decoratedFigure.handleMousePressed(event);
    }

    @Override
    public void handleMouseReleased(MouseEvent event) {
        decoratedFigure.handleMouseReleased(event);
    }

    @Override
    public boolean hasFocus() {
        return decoratedFigure.hasFocus();
    }

    @Override
    public EventDispatcher internalGetEventDispatcher() {
        return decoratedFigure.internalGetEventDispatcher();
    }

    @Override
    public boolean intersects(Rectangle rect) {
        return decoratedFigure.intersects(rect);
    }

    @Override
    public void invalidate() {
        decoratedFigure.invalidate();
    }

    @Override
    public void invalidateTree() {
        decoratedFigure.invalidateTree();
    }

    @Override
    public boolean isCoordinateSystem() {
        return decoratedFigure.isCoordinateSystem();
    }

    @Override
    public boolean isEnabled() {
        return decoratedFigure.isEnabled();
    }

    @Override
    public boolean isFocusTraversable() {
        return decoratedFigure.isFocusTraversable();
    }

    @Override
    public boolean isMirrored() {
        return decoratedFigure.isMirrored();
    }

    @Override
    public boolean isOpaque() {
        return decoratedFigure.isOpaque();
    }

    @Override
    public boolean isRequestFocusEnabled() {
        return decoratedFigure.isRequestFocusEnabled();
    }

    @Override
    public boolean isShowing() {
        return decoratedFigure.isShowing();
    }

    @Override
    public boolean isVisible() {
        return decoratedFigure.isVisible();
    }

    @Override
    public void paint(Graphics graphics) {
        decoratedFigure.paint(graphics);
    }

    @Override
    public void remove(IFigure figure) {
        decoratedFigure.remove(figure);
    }

    @Override
    public void removeAncestorListener(AncestorListener listener) {
        decoratedFigure.removeAncestorListener(listener);
    }

    @Override
    public void removeCoordinateListener(CoordinateListener listener) {
        decoratedFigure.removeCoordinateListener(listener);
    }

    @Override
    public void removeFigureListener(FigureListener listener) {
        decoratedFigure.removeFigureListener(listener);
    }

    @Override
    public void removeFocusListener(FocusListener listener) {
        decoratedFigure.removeFocusListener(listener);
    }

    @Override
    public void removeKeyListener(KeyListener listener) {
        decoratedFigure.removeKeyListener(listener);
    }

    @Override
    public void removeLayoutListener(LayoutListener listener) {
        decoratedFigure.removeLayoutListener(listener);
    }

    @Override
    public void removeMouseListener(MouseListener listener) {
        decoratedFigure.removeMouseListener(listener);
    }

    @Override
    public void removeMouseMotionListener(MouseMotionListener listener) {
        decoratedFigure.removeMouseMotionListener(listener);
    }

    @Override
    public void removeNotify() {
        decoratedFigure.removeNotify();
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        decoratedFigure.removePropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String property, PropertyChangeListener listener) {
        decoratedFigure.removePropertyChangeListener(property, listener);
    }

    @Override
    public void repaint() {
        decoratedFigure.repaint();
    }

    @Override
    public void repaint(int x, int y, int w, int h) {
        decoratedFigure.repaint(x, y, w, h);
    }

    @Override
    public void repaint(Rectangle rect) {
        decoratedFigure.repaint(rect);
    }

    @Override
    public void requestFocus() {
        decoratedFigure.requestFocus();
    }

    @Override
    public void revalidate() {
        decoratedFigure.revalidate();
    }

    @Override
    public void setBackgroundColor(Color c) {
        decoratedFigure.setBackgroundColor(c);
    }

    @Override
    public void setBorder(Border b) {
        decoratedFigure.setBorder(b);
    }

    @Override
    public void setBounds(Rectangle rect) {
        decoratedFigure.setBounds(rect);
    }

    @Override
    public void setClippingStrategy(IClippingStrategy clippingStrategy) {
        decoratedFigure.setClippingStrategy(clippingStrategy);
    }

    @Override
    public void setConstraint(IFigure child, Object constraint) {
        decoratedFigure.setConstraint(child, constraint);
    }

    @Override
    public void setCursor(Cursor cursor) {
        decoratedFigure.setCursor(cursor);
    }

    @Override
    public void setEnabled(boolean value) {
        decoratedFigure.setEnabled(value);
    }

    @Override
    public void setFocusTraversable(boolean value) {
        decoratedFigure.setFocusTraversable(value);
    }

    @Override
    public void setFont(Font f) {
        decoratedFigure.setFont(f);
    }

    @Override
    public void setForegroundColor(Color c) {
        decoratedFigure.setForegroundColor(c);
    }

    @Override
    public void setLayoutManager(LayoutManager lm) {
        decoratedFigure.setLayoutManager(lm);
    }

    @Override
    public void setLocation(Point p) {
        decoratedFigure.setLocation(p);
    }

    @Override
    public void setMaximumSize(Dimension size) {
        decoratedFigure.setMaximumSize(size);
    }

    @Override
    public void setMinimumSize(Dimension size) {
        decoratedFigure.setMinimumSize(size);
    }

    @Override
    public void setOpaque(boolean isOpaque) {
        decoratedFigure.setOpaque(isOpaque);
    }

    @Override
    public void setParent(IFigure parent) {
        decoratedFigure.setParent(parent);
    }

    @Override
    public void setPreferredSize(Dimension size) {
        decoratedFigure.setPreferredSize(size);
    }

    @Override
    public void setRequestFocusEnabled(boolean requestFocusEnabled) {
        decoratedFigure.setRequestFocusEnabled(requestFocusEnabled);
    }

    @Override
    public void setSize(Dimension d) {
        decoratedFigure.setSize(d);
    }

    @Override
    public void setSize(int w, int h) {
        decoratedFigure.setSize(w, h);
    }

    @Override
    public void setToolTip(IFigure figure) {
        decoratedFigure.setToolTip(figure);
    }

    @Override
    public void setVisible(boolean visible) {
        decoratedFigure.setVisible(visible);
    }

    @Override
    public void translate(int x, int y) {
        decoratedFigure.translate(x, y);
    }

    @Override
    public void translateFromParent(Translatable t) {
        decoratedFigure.translateFromParent(t);
    }

    @Override
    public void translateToAbsolute(Translatable t) {
        decoratedFigure.translateToAbsolute(t);
    }

    @Override
    public void translateToParent(Translatable t) {
        decoratedFigure.translateToParent(t);
    }

    @Override
    public void translateToRelative(Translatable t) {
        decoratedFigure.translateToRelative(t);
    }

    @Override
    public void validate() {
        decoratedFigure.validate();
    }

}
