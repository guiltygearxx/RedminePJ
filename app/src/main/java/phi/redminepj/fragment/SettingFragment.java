package phi.redminepj.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import phi.redminepj.R;


public class SettingFragment extends Fragment {
    LinearLayout btnContact, btnFAQ, btnAccountSetup, btnCompany, btnFacebook,btnReview;
    Button btnAccountAdd, btnCancel, btnSend;
    WebView webCompany, webFaq;
    EditText textCategory, textDescription;
    RadioButton rb0, rb1, rb2, rb3;
    RelativeLayout relativeStart,relativeContact;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        btnContact = (LinearLayout) view.findViewById(R.id.btnContact);
        btnFAQ = (LinearLayout) view.findViewById(R.id.btnFAQ);
        btnAccountSetup = (LinearLayout) view.findViewById(R.id.btnAccountSetup);
        btnCompany = (LinearLayout) view.findViewById(R.id.btnCompany);
        btnFacebook = (LinearLayout) view.findViewById(R.id.btnFacebook);
        btnReview = (LinearLayout) view.findViewById(R.id.btnReview);
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity(), R.style.AppTheme_NoActionBar);
                dialog.setContentView(R.layout.fragment_contact);
                textCategory = (EditText) dialog.findViewById(R.id.textCategory);
                textDescription = (EditText) dialog.findViewById(R.id.textDescription);
                btnSend = (Button) dialog.findViewById(R.id.btnSend);
                relativeContact = (RelativeLayout)dialog.findViewById(R.id.relativeContact);
                textCategory.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Dialog dialog = new Dialog(getActivity());
                        dialog.setContentView(R.layout.list_contact_category);
                        rb0 = (RadioButton) dialog.findViewById(R.id.rb0);
                        rb1 = (RadioButton) dialog.findViewById(R.id.rb1);
                        rb2 = (RadioButton) dialog.findViewById(R.id.rb2);
                        rb3 = (RadioButton) dialog.findViewById(R.id.rb3);
                        btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
                        rb0.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                textCategory.setText("Bug report");
                                dialog.dismiss();
                            }
                        });
                        rb1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                textCategory.setText("Feature request");
                                dialog.dismiss();
                            }
                        });
                        rb2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                textCategory.setText("Feedback");
                                dialog.dismiss();
                            }
                        });
                        rb3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                textCategory.setText("Other");
                                dialog.dismiss();
                            }
                        });
                        btnCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                        dialog.setCancelable(true);
                        dialog.setTitle("Category");
                        dialog.show();
                    }
                });
                btnSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String category = textCategory.getText().toString();
                        String description = textDescription.getText().toString();
                        Intent emailIntent = new Intent(Intent.ACTION_SEND);
                        emailIntent.setType("message/rfc822");
                        String[] TO = {"nguyenvannam19942802@gmail.com"};
                        String[] CC = {"nguyenvannam19942802@gmail.com"};
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                        emailIntent.putExtra(Intent.EXTRA_CC, CC);
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, category);
                        emailIntent.putExtra(Intent.EXTRA_TEXT, description);

                        try {
                            startActivity(Intent.createChooser(emailIntent,"Choose email client..."));
                            dialog.dismiss();
                        }
                        catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(getContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                relativeContact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.setCancelable(true);
                dialog.setTitle("Contact");
                dialog.show();
            }
        });

        btnFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity(), R.style.AppTheme_NoActionBar);
                dialog.setContentView(R.layout.fragment_faq);
                relativeStart = (RelativeLayout)dialog.findViewById(R.id.relativeStart);
                relativeStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                webFaq = (WebView) dialog.findViewById(R.id.webFaq);
                webFaq.getSettings().setJavaScriptEnabled(true);
                webFaq.loadUrl("http://redminepm.com/faq/");
                dialog.setCancelable(true);
                dialog.setTitle("FAQ");
                dialog.show();
            }
        });

        btnAccountSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity(), R.style.AppTheme_NoActionBar);
                dialog.setContentView(R.layout.fragment_account_list);
                btnAccountAdd = (Button) dialog.findViewById(R.id.btnAccountAdd);
                btnAccountAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Dialog dialog = new Dialog(getActivity(), R.style.AppTheme_NoActionBar);
                        dialog.setContentView(R.layout.fragment_account_edit);
                        dialog.setCancelable(true);
                        dialog.setTitle("Edit account");
                        dialog.show();
                    }
                });
                dialog.setCancelable(true);
                dialog.setTitle("Edit Account");
                dialog.show();
            }
        });

        btnCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity(), R.style.AppTheme_NoActionBar);
                dialog.setContentView(R.layout.fragment_company);
                webCompany = (WebView) dialog.findViewById(R.id.webConpany);
                webCompany.getSettings().setJavaScriptEnabled(true);
                webCompany.loadUrl("http://beta.phi.vn/");
                dialog.setCancelable(true);
                dialog.setTitle("Edit account");
                dialog.show();
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/phi.vn/"));
                startActivity(intent);
            }
        });

        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=hn.christmas.winter.snowflakes"));
                startActivity(intent);
            }
        });
        return view;
    }
}
