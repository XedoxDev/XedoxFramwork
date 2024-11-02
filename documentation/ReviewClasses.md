# Review classes 

# XSurfaceView 
It is the heir of the SurfaceView class.To create an object, you need to pass the context and the start screen (the successor of the ScreenAdapter). It is needed to display screens (Games). 
Example:
’’’java
XSurfaceView xview = new XSurfaceView(MainActivity.this, new MainScreen());
setContentView(xview);
’’’
**Methods**
 - getScreen() | return ScreenAdapter
   Returned current screen.
 - setScreen(ScreenAdapter)
   Installs a new screen

# ScreenAdapter 
By its very nature, it is a stage.
**Methods**
 - start()
   Called when the screen is installed.
 - render(Canvas)
   Called when update screen.
 - setScreen(ScreenAdapter)
   sets a new screen in XSurfaceView.
 - touchEvent, pressed, moved, released(MotionEvent, int, int)
   they are called depending on the action with the touch.   
  
