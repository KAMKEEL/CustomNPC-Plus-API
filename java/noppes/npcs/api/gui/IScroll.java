//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package noppes.npcs.api.gui;

public interface IScroll extends ICustomGuiComponent {
    int getWidth();

    int getHeight();

    IScroll setSize(int width, int height);

    String[] getList();

    IScroll setList(String[] textList);

    int getDefaultSelection();

    IScroll setDefaultSelection(int defaultSelection);

    boolean isMultiSelect();

    IScroll setMultiSelect(boolean selectMultiple);
}
