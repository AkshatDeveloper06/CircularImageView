# Add any ProGuard configurations specific to this
# extension here.

-keep public class in.akshatt.CircularImageView.CircularImageView {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'in/akshatt/CircularImageView/repack'
-flattenpackagehierarchy
-dontpreverify
