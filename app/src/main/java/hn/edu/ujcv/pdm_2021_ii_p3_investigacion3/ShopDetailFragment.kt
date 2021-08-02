package hn.edu.ujcv.pdm_2021_ii_p3_investigacion3

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import hn.edu.ujcv.pdm_2021_ii_p3_investigacion3.placeholder.PlaceholderContent
import hn.edu.ujcv.pdm_2021_ii_p3_investigacion3.databinding.FragmentShopDetailBinding

/**
 * A fragment representing a single Shop detail screen.
 * This fragment is either contained in a [ShopListFragment]
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
class ShopDetailFragment : Fragment() {

    /**
     * The placeholder content this fragment is presenting.
     */
    private var item: PlaceholderContent.PlaceholderItem? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the placeholder content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = PlaceholderContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                activity?.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)?.title=item?.shop_name
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val rootView = inflater.inflate(R.layout.shop_detail,container,false)




        // Show the placeholder content as text in a TextView.
        item?.let {
            val webview:WebView = rootView.findViewById(R.id.shop_detail)

            webview.webViewClient = object: WebViewClient(){
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    return super.shouldOverrideUrlLoading(view, request)
                }
            }
            webview.loadUrl(it.shop_url)
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }

}