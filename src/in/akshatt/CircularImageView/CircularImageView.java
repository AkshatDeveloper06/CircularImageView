package in.akshatt.CircularImageView;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.YailList;
import android.app.Activity;
import android.content.Context;
import in.akshatt.CircularImageView.lib.CircleImageViewLibrary;

import java.io.IOException;

public class CircularImageView extends AndroidNonvisibleComponent {
  private Context context;
  private Activity activity;
  private ComponentContainer container;
  private CircleImageViewLibrary circleImageViewLibrary;

  public CircularImageView(ComponentContainer container) {
    super(container.$form());
    this.container = container;
    this.context = container.$context();
    this.activity = container.$context();
    circleImageViewLibrary = new CircleImageViewLibrary(context);
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR, defaultValue = DEFAULT_VALUE_COLOR_GREEN)
  @SimpleProperty
  public void SetBorderColor(int color){
    circleImageViewLibrary.setBorderColor(color);
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR, defaultValue = DEFAULT_VALUE_COLOR_GREEN)
  @SimpleProperty
  public void SetCircleBGColor(int color){
    circleImageViewLibrary.setCircleBackgroundColor(color);
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_INTEGER, defaultValue = "5")
  @SimpleProperty
  public void SetBorderWidth(int width){
    circleImageViewLibrary.setBorderWidth(width);
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
  @SimpleProperty
  public void SetBorderOverlay(boolean overlay){
    circleImageViewLibrary.setBorderOverlay(overlay);
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
  @SimpleProperty
  public void SetDisableCircularTransformation(boolean transform){
    circleImageViewLibrary.setDisableCircularTransformation(transform);
  }

  @SimpleFunction(description = "")
  public void Show(AndroidViewComponent in, String image) throws IOException {
    // Getting image and adding it to drawable
    Drawable imageDrawable = MediaUtil.getBitmapDrawable(form, image);
    circleImageViewLibrary.setImageDrawable(imageDrawable);

    // Showing the circle image view
    FrameLayout frameLayout = (FrameLayout) in.getView();
    frameLayout.addView(circleImageViewLibrary);
  }


}
