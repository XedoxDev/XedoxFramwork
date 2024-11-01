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

    Sprite sprite;

    @Override
    public void start() {
        sprite = new Sprite(this);
         sprite.loadBitmap(App.context, "player.png");
        sprite.setSize(100, 100);
    }

    @Override
    public void render(Canvas canvas) {
        sprite.draw();
    }
}
```

Load images (sprites) in folder app/src/main/assets for use and render.
