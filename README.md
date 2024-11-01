# XedoxFramwork
A simple structured 2D graphical framework for Android.

# Get started
1. Download [the framework](github.com/XedoxDev/XedoxFramwork/releases/download/v0.0.1) and move to app/libs/ to your Android project.
2. Add file in dependencies:
```gradle
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.aar'])
}
```
for using.

3. Create XSurfaceView, for visible.
```java
XSurfaceView view = new XSurfaceView(this, new Main());
setContentView(view);
```
4. Create main Screen. create a class inheriting ScreenAdapter, override the start and render methods. Example:
```java
public class Main extends IScreen {

    private Sprite sprite;
    private SpriteManager sm;
    private RenderManager rm;

    @Override
    public void start() {
        sm = new SpriteManager();
        rm = new RenderManager(this);
        sprite = new Sprite(this);
        sprite.setSprite(sm.readSprite(view.getContext(), "spriteName.png");
        sprite.setSize(100, 100);
        rm.add(sprite);
    }

    @Override
    public void render(Canvas canvas) {
        canvas.drawColor(0xFF000000); // BLACK
        rm.displayObjects();
    }
}
```

Load images (sprites) in folder app/src/main/assets for use and render.
