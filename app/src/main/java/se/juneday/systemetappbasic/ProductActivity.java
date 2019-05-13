package se.juneday.systemetappbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;
import se.juneday.systemetappbasic.domain.Product;


public class ProductActivity extends AppCompatActivity {

    private static final String LOG_TAG = ProductActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.product_activity);

      // extract the Product pass in the bundle
      Bundle extras = getIntent().getExtras();
      Product p = (Product) extras.get("product");
      // display the product
      displayProduct(p);
    }

    private void setViewText(int viewId, String label, String text) {
      TextView tv = findViewById(viewId);
      tv.setText(Html.fromHtml("<b>"+label+"</b>: " + text));
      Log.d(LOG_TAG, " * " + label + " | " + text);
    }

    private void displayProduct(Product product) {
      setViewText(R.id.product_name, getString(R.string.name), product.name());
      setViewText(R.id.product_volume, getString(R.string.volume), String.valueOf(product.volume()));
      setViewText(R.id.product_alcohol, getString(R.string.alcohol), String.valueOf(product.alcohol()));
      setViewText(R.id.product_price, getString(R.string.price), String.valueOf(product.price()));
      setViewText(R.id.product_group, getString(R.string.productGroup), String.valueOf(product.productGroup()));
    }

  }

