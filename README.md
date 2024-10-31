# XedoxFramwork
Android 2D Graphics FW for Android.

The framework is great for simple 2D games, there is no documentation yet, but the code and structure are very simple.

# Get started
1. Download [the framework](github.com/XedoxDev/XedoxFramwork/releases/download/v0.0.1) and move to app/libs/ to your Android project.
2. Add file in dependencies:
```gradle
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.aar'])
}
```
for using.

3. Create XSurfaceView, add main screen:
```java
XSurfaceView view = new XSurfaceView(this, new Main());
setContentView(view);
```
4. Create main Screen. create a class inheriting IScreen, override the start and render methods. Example:
```java
public class Main extends IScreen {

    Sprite sprite;

    @Override
    public void start() {
        try {
            sprite = new Sprite(this);
            sprite.loadBitmap(App.context, "player.png");
            sprite.setSize(100, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(Canvas canvas) {
        try {
            sprite.draw();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

Load images (sprites) in folder app/src/main/assets for use and render.
