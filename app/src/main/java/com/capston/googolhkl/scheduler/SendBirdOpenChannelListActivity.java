package com.capston.googolhkl.scheduler;

// 여기에 오픈 채팅 리스트 보여주고 옵션 선택까지 있음 btn_version  주석 : 내가 만든 채팅방 생성하기
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.capston.googolhkl.schduler.R;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.OpenChannelListQuery;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class SendBirdOpenChannelListActivity extends FragmentActivity {
    private SendBirdChannelListFragment mSendBirdChannelListFragment;

    private View mTopBarContainer;
    private View mSettingsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.sendbird_slide_in_from_bottom, R.anim.sendbird_slide_out_to_top);
        setContentView(R.layout.activity_sendbird_open_channel_list);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        initFragment();
        initUIComponents();
    }

    @Override
    protected void onResume() {
        super.onResume();
        /**
         * If the minimum SDK version you support is under Android 4.0,
         * you MUST uncomment the below code to receive push notifications.
         */
//        SendBird.notifyActivityResumedForOldAndroids();
    }

    @Override
    protected void onPause() {
        super.onPause();
        /**
         * If the minimum SDK version you support is under Android 4.0,
         * you MUST uncomment the below code to receive push notifications.
         */
//        SendBird.notifyActivityPausedForOldAndroids();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        resizeMenubar();
    }

    private void resizeMenubar() {
        ViewGroup.LayoutParams lp = mTopBarContainer.getLayoutParams();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            lp.height = (int) (28 * getResources().getDisplayMetrics().density);
        } else {
            lp.height = (int) (48 * getResources().getDisplayMetrics().density);
        }
        mTopBarContainer.setLayoutParams(lp);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.sendbird_slide_in_from_top, R.anim.sendbird_slide_out_to_bottom);
    }

    private void initFragment() {
        mSendBirdChannelListFragment = new SendBirdChannelListFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, mSendBirdChannelListFragment)
                .commit();
    }


    // 오픈채널 보여주고 만들 때
    private void initUIComponents() {
        mTopBarContainer = findViewById(R.id.top_bar_container);

        mSettingsContainer = findViewById(R.id.settings_container);
        mSettingsContainer.setVisibility(View.GONE);

        findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.btn_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSettingsContainer.getVisibility() != View.VISIBLE) {
                    mSettingsContainer.setVisibility(View.VISIBLE);
                } else {
                    mSettingsContainer.setVisibility(View.GONE);
                }
            }
        });


        // 채팅방 만들기
        findViewById(R.id.btn_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = SendBirdOpenChannelListActivity.this.getLayoutInflater().inflate(R.layout.sendbird_view_open_create_channel, null);
                final EditText chName = (EditText) view.findViewById(R.id.etxt_chname);

                new AlertDialog.Builder(SendBirdOpenChannelListActivity.this)
                        .setView(view)
                        .setTitle("Create Open Channel")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                List<User> operators = new ArrayList<>();
                                operators.add(SendBird.getCurrentUser());

                                OpenChannel.createChannel(chName.getText().toString(), null, null, operators, new OpenChannel.OpenChannelCreateHandler() {
                                    @Override
                                    public void onResult(OpenChannel openChannel, SendBirdException e) {
                                        if (e != null) {
                                            Toast.makeText(SendBirdOpenChannelListActivity.this, "" + e.getCode() + ":" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                            return;
                                        }

                                        if (!mSendBirdChannelListFragment.mChannelListQuery.hasNext()) {
                                            mSendBirdChannelListFragment.mAdapter.add(openChannel);
                                        }

                                        Intent intent = new Intent(SendBirdOpenChannelListActivity.this, SendBirdOpenChatActivity.class);
                                        intent.putExtra("channel_url", openChannel.getUrl());
                                        startActivity(intent);
                                    }
                                });
                            }
                        })
                        .setNegativeButton("Cancel", null).create().show();

                mSettingsContainer.setVisibility(View.GONE);
            }
        });

        findViewById(R.id.btn_version).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SendBirdOpenChannelListActivity.this)
                        .setTitle("SendBird")
                        .setMessage("SendBird SDK " + SendBird.getSDKVersion())
                        .setPositiveButton("OK", null).create().show();

                mSettingsContainer.setVisibility(View.GONE);
            }
        });

        // 내가 만든 채팅방 생성하기
        findViewById(R.id.open_chatting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = SendBirdOpenChannelListActivity.this.getLayoutInflater().inflate(R.layout.sendbird_view_open_create_channel, null);
                final EditText chName = (EditText) view.findViewById(R.id.etxt_chname); // 학교이름과 과목번호로 생성하도록 수정해야함

                new AlertDialog.Builder(SendBirdOpenChannelListActivity.this)
                        .setView(view)
                        .setTitle("채팅방 생성")
                        .setPositiveButton("생성", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                /*
                                List<User> operators = new ArrayList<>();
                                operators.add(SendBird.getCurrentUser());

                                OpenChannel.createChannel(chName.getText().toString(), null, null, operators, new OpenChannel.OpenChannelCreateHandler() {
                                    @Override
                                    public void onResult(OpenChannel openChannel, SendBirdException e) {
                                        if (e != null) {
                                            Toast.makeText(SendBirdOpenChannelListActivity.this, "" + e.getCode() + ":" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                            return;
                                        }
                                        HashMap<String, String> data = new HashMap<String, String>();
                                        data.put("hello","world");
                                        openChannel.createMetaData(data, new BaseChannel.MetaDataHandler() {
                                            @Override
                                            public void onResult(Map<String, String> map, SendBirdException e) {
                                                if(e != null){
                                                    return;
                                                }

                                            }
                                        });

                                        if (!mSendBirdChannelListFragment.mChannelListQuery.hasNext()) {
                                            mSendBirdChannelListFragment.mAdapter.add(openChannel);
                                        }



                                        Intent intent = new Intent(SendBirdOpenChannelListActivity.this, SendBirdOpenChatActivity.class);
                                        intent.putExtra("channel_url", openChannel.getUrl());
                                        startActivity(intent);
                                    }
                                });
                                */
                                OpenChannelListQuery mChannelListQuery = OpenChannel.createOpenChannelListQuery();
                                mChannelListQuery.next(new OpenChannelListQuery.OpenChannelListQueryResultHandler() {
                                    @Override
                                    public void onResult(List<OpenChannel> channels, SendBirdException e) {
                                        if (e != null) {
                                            Toast.makeText(SendBirdOpenChannelListActivity.this, "error1!!", Toast.LENGTH_SHORT).show();
                                            return;
                                        }

                                        final List<String> keys = new ArrayList<String>();
                                        keys.add("hello");

                                        for(int i=0; i<channels.size(); i++) {
                                            final OpenChannel channel = channels.get(i);
                                            channels.get(i).getMetaData(keys, new BaseChannel.MetaDataHandler() {
                                                @Override
                                                public void onResult(Map<String, String> map, SendBirdException e) {
                                                    if (e != null) {
                                                        Toast.makeText(SendBirdOpenChannelListActivity.this, "error2!!", Toast.LENGTH_SHORT).show();
                                                        return;
                                                    }

                                                    String str =  map.get("hello");
                                                    // 방이 있을 때 바로 입장
                                                    if("world".equals(str)) {
                                                        Intent intent = new Intent(SendBirdOpenChannelListActivity.this, SendBirdOpenChatActivity.class);
                                                        intent.putExtra("channel_url", channel.getUrl());
                                                        Toast.makeText(SendBirdOpenChannelListActivity.this, "open!!", Toast.LENGTH_SHORT).show();
                                                        startActivity(intent);
                                                    }
                                                    else{ //방이 없을 때는 만들고 입장
                                                        Toast.makeText(SendBirdOpenChannelListActivity.this, "close!!", Toast.LENGTH_SHORT).show();

                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        })
                        .setNegativeButton("취소", null).create().show();

                mSettingsContainer.setVisibility(View.GONE);
            }
        });

        resizeMenubar();

    }



    public static class SendBirdChannelListFragment extends Fragment {
        private ListView mListView;
        private OpenChannelListQuery mChannelListQuery;
        private SendBirdChannelAdapter mAdapter;

        public SendBirdChannelListFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.sendbird_fragment_open_channel_list, container, false);
            initUIComponents(rootView);

            mListView.setAdapter(mAdapter);

            return rootView;
        }

        private void initUIComponents(View rootView) {
            mListView = (ListView) rootView.findViewById(R.id.list);
            mAdapter = new SendBirdChannelAdapter(getActivity());


            // 해당 채팅방 클릭시 입장
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    OpenChannel channel = mAdapter.getItem(position);
                    Intent intent = new Intent(getActivity(), SendBirdOpenChatActivity.class);
                    intent.putExtra("channel_url", channel.getUrl());
                    startActivity(intent);
                }
            });

            mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    if (firstVisibleItem + visibleItemCount >= (int) (totalItemCount * 0.8f)) {
                        loadMoreChannels();
                    }
                }
            });
        }

        private void loadMoreChannels() {
            if (mChannelListQuery != null && mChannelListQuery.hasNext() && !mChannelListQuery.isLoading()) {
                mChannelListQuery.next(new OpenChannelListQuery.OpenChannelListQueryResultHandler() {
                    @Override
                    public void onResult(List<OpenChannel> channels, SendBirdException e) {
                        if (e != null) {
                            return;
                        }

                        mAdapter.addAll(channels);
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }
        }

        @Override
        public void onResume() {
            super.onResume();

            mAdapter.clear();
            mAdapter.notifyDataSetChanged();

            mChannelListQuery = OpenChannel.createOpenChannelListQuery();
            mChannelListQuery.next(new OpenChannelListQuery.OpenChannelListQueryResultHandler() {
                @Override
                public void onResult(List<OpenChannel> channels, SendBirdException e) {
                    if (e != null) {
                        Toast.makeText(getActivity(), "" + e.getCode() + ":" + e.getMessage()+"123", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (channels.size() <= 0) {
                        Toast.makeText(getActivity(), "No channels were found.", Toast.LENGTH_SHORT).show();
                    } else {
                        mAdapter.addAll(channels);
                    }
                }
            });

        }

        public static class SendBirdChannelAdapter extends BaseAdapter {
            private final LayoutInflater mInflater;
            private final ArrayList<OpenChannel> mItemList;

            public SendBirdChannelAdapter(Context context) {
                mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                mItemList = new ArrayList<>();
            }

            @Override
            public int getCount() {
                return mItemList.size();
            }

            @Override
            public OpenChannel getItem(int position) {
                return mItemList.get(position);
            }

            public void clear() {
                mItemList.clear();
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            public void add(OpenChannel channel) {
                mItemList.add(channel);
                notifyDataSetChanged();
            }

            public void addAll(Collection<OpenChannel> channels) {
                mItemList.addAll(channels);
                notifyDataSetChanged();
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder;

                if (convertView == null) {
                    viewHolder = new ViewHolder();

                    convertView = mInflater.inflate(R.layout.sendbird_view_open_channel, parent, false);
                    viewHolder.setView("img_thumbnail", convertView.findViewById(R.id.img_thumbnail));
                    viewHolder.setView("txt_topic", convertView.findViewById(R.id.txt_topic));
                    viewHolder.setView("txt_desc", convertView.findViewById(R.id.txt_desc));

                    convertView.setTag(viewHolder);
                }

                OpenChannel item = getItem(position);
                viewHolder = (ViewHolder) convertView.getTag();
                Helper.displayUrlImage(viewHolder.getView("img_thumbnail", ImageView.class), item.getCoverUrl());
                viewHolder.getView("txt_topic", TextView.class).setText("#" + item.getName());
                viewHolder.getView("txt_desc", TextView.class).setText("" + item.getParticipantCount() + ((item.getParticipantCount() <= 1) ? " Member" : " Members"));

                return convertView;
            }

            private static class ViewHolder {
                private Hashtable<String, View> holder = new Hashtable<>();

                public void setView(String k, View v) {
                    holder.put(k, v);
                }

                public View getView(String k) {
                    return holder.get(k);
                }

                public <T> T getView(String k, Class<T> type) {
                    return type.cast(getView(k));
                }
            }
        }
    }
}
