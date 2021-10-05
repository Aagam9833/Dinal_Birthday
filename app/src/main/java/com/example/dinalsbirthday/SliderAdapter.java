package com.example.dinalsbirthday;

import android.app.DatePickerDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.Calendar;

public class SliderAdapter extends PagerAdapter {
    private static final String TAG = "MyActivity";
    Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] sliderImage = {R.drawable.ritika,R.drawable.suri,R.drawable.nati,R.drawable.pranav,R.drawable.golu,R.drawable.zeel,R.drawable.chaitali,R.drawable.ashna,
                                R.drawable.sakshi,R.drawable.kulin,R.drawable.bavad,R.drawable.danke,R.drawable.dweep,R.drawable.maulik,R.drawable.prabhleen,R.drawable.brinda,
                                R.drawable.eshan,R.drawable.dimple,R.drawable.krunal,R.drawable.harsh,
                                R.drawable.parth,R.drawable.sanyogita};

    public String[] sliderHints = {"You messaged me on Facebook and the rest is history",

            "Person with whom you’ve tried many things for the first time \n Your roommates miss him more than they’d miss you",

            "Still waiting for a comeback! ",

            "Could have been a friend, a brother, a partner in getting drunk, but you chose me as a drug dealer? \uD83E\uDD14",

            "Or ‘It wouldn’t matter if we exchange our names on the lease’",

            "Mere muh mein sprite hai #shahsisters",

            "\uD83D\uDC46\uD83E\uDDC0\uD83C\uDFF8\uD83D\uDC4C\uD83D\uDC4C",

            "Khelna nahi aata, toh cheating toh mat karo",

            "Grocery shopping after exams is our happy place!",

            "Tu sirf iske bolne pe BU aayi hai",

            "I gave the world ‘maasi’",

            "Danké",

            "The one who gave you danilya",

            "Jai jinendra",

            "Selfie Partner",

            "Bharat milap on railway station and every ready to kiss you on lips",

            "Potty Pants",

            "You call me superwoman and for me you are always one of the most confident and strong woman that I have met!! ",

            "Twinkle twinkle little star,\n" +
                    "How I wonder “where” you are,\n" +
                    "Up above the world so high, \n" +
                    "Between our moon and our sky,\n" +
                    "\n" +
                    "Twinkle twinkle little star,\n" +
                    "How I wonder what you are",

            "Agar Daru mein nasha hota toh bottlein na jhoomti.. if you remember this time.",

            "Who is the “Rats” to your “Meow”?",

            "Spent a beautiful evening together staring at the Manhattan skyline, eating Magnolia banana pudding, and sharing life stories",
    };

    public String[] sliderAnswer = {"ritika","suri","nati","pranav","golu","zeel","chaitali","ashna","sakshi","kulin","bavad","vaibhav","dweep","maulik","prabhleen",
                                    "brinda","eshan","dimple","krunal","harsh","parth","sanyogita"};

    public String[] sliderMessage = {" Dinal!!! OMG I miss you so much! You mean so much to me and you have no clue what an inspiration you are for everyone around you. Thank you for being born, for choosing Boston and doing all the hard work in looking out for an apartment and roommate in 2016 ;) I just got lucky! \n" +
            "\n" +
            "Today on your birthday, I not only wish you love and happiness, but I also would like to take this opportunity to tell you that I've still not eaten your \"signature\" paprika rice. Can you please visit me soon and cook for me again?!",


            "Happy birthday Motabhai! You’re not only my friend but my family. You’re the elder sister I never had. Having shared so many secrets, experiences and the highs and lows of life, I’m confident that there can’t be a better person or a human that God has sent on this planet. Yes, Bhagwaan ne tujhe aisa hi banaya \uD83D\uDE09 \n" +
                    "Stay as awesome you are, and all the best for whatever is coming, always a call away.\n" +
                    "\n" +
                    "Yours,\n" +
                    "Suri",


            "Happy birthday Drams! \uD83D\uDE18\uD83C\uDF89\uD83C\uDF7B\n" +
                    "Finally 30! You still act like thirteen though. Well, not much can be done about that. Turns out with your 30th, there are a ton of changes and challenges coming up right from our group splitting up, to people searching for new jobs in remote locations \uD83D\uDE0B. But I’m sure you’re going to take everything like a champ as you have done time and again. Have a great birthday overshadowing mine yet again and keep irritating those around you! Cheers! \uD83C\uDF7B\uD83D\uDE18\n" +
                    "\n" +
                    "Nati",


            "Every word spoken by me for you,however COLD it must be, has a meaning behind it. You don’t know this but you really are a warm HEARTED person and someone who everybody can trust on. And lastly, if you do decode this remember one thing- Ye bol hum rahe hai par sabd tumhare hai so life is truly a BITCH and we you’ll have to deal with it.\n" +
                    "Thank you and for more inspirational quotes follow me on twitter or message me on whatsapp✌\uD83C\uDFFB",


            "Hi Dinal,\n" +
                    "Thank you for leading our ways to Old age (officially). Please keep sharing your experiences with us so that they can guide the others through the dark ages. Even though on paper you are 30, practically you are 13. So when someone asks you how old are you, your reply should be ‘30 year young’. \n" +
                    "\n" +
                    "Wish you a very very Happy 30. Love you Masi \uD83D\uDE18\n" +
                    "-golu",


            "Dinaaall happy happy birthday!! We miss you so so much! Come home soon! Hope this year brings so much laughter, joy, dance and happiness ❤️❤️❤️",


            "Dinall!! Happy birthday to you\uD83D\uDE18\uD83D\uDE18 \n" +
                    "It feels like years since I have met you - absolutely miss your crazy, your full on enthu, your dance and obviously garba and your dhamaal party mode!!\uD83D\uDE18 Jaldi Dubai aa please\uD83E\uDD73\n" +
                    "While we might to talk very often (stupid adulting), it still feels the same everytime we do! Stay the crazy person that you are coz you are our type of crazy!!!❤️❤️",


            "Happy Birthday D!!! \n" +
                    "Draamebaaz jukebox of the group, they say things get better with age…. Still waiting for that to happen :P \n" +
                    "Hope you have a great bday, phulo falo masti karo taraki karo ( desh chala lia, duniya time? ) and always keep smiling. Your are one of the strongest and determined person I know just NEVER change that. \n" +
                    "Love you loads <3 <3 <3\n" +
                    "Ashna",


            " I dont think I can write a few words for you and it will say all that you mean to me. You are my safe haven in this mad world. I’m too used to the idea of you being around that everything feels off if you aren’t. I’m stopping here because i can legit write a novel here \uD83D\uDE0C Stay this crazy drama person forever and better get into the habit of calling me daily ☺️",


            "30 is 3 perfects 10s!!! Happy dirty thirty Di-nal!",


            "Happy birthday masi!!\n" +
                    "Bavad",


            "Very Many Happy return of the day Dinal of Shah dynasty. May the lord bless you with a covid free year.\n" +
                    "\"You have to get older, but you don’t have to grow up\", literally or figuratively. Whatever floats your boat.",


            "Happy 30th Birthday Danilyaa!! My partner in soulful singing, these 5 Boston years would have been incomplete without you. Id probably still be giving the Portfolio theory paper if it wasnt for you. \n" +
                    "Make sure this old age doesnt remove even one bit of the craziness and the child inside you\uD83D\uDE18\uD83D\uDE18\uD83D\uDE18 Happy happy birthday, love youu\uD83D\uDE18\uD83D\uDE18",


            "Happy bday Massi! Fulo falo khoop khoop jivo! Jai jinendra",


            "D!!! Happyyy happyyy birthdaayyy bro!!! Can't wait for you to get a job on the west coast!! You bring so much happiness into our lives, but at the same time, I am still waiting for my Christmas gift :/ From you ONLY hanging out with the Mumbai peeps to being my roommate and such an amazing selfie partner, it has been a crazy ride and I hope you keep being the crazy singer you are and wish all the happiness and success for you because you undoubtedly deserve it! I love you <3",


            "Laughing always, I am there by your side no matter what and the comfort I get in you, I get in no one... I feel so secure with you and our friendship that I am myself 10000 % I love you beyond words and yes next janam plz lets flirt and be lesbians",


            "Dinudii, since you are looking at this page means that you were successfully able to identify yourself as Potty Pants \uD83D\uDE1B!! It's been what, 12 years since we have known each other. My only 'long hair' admirer \uD83D\uDE02, Scholar Naina, etc etc.. Shabd nahi hai mere paas. I know there are a lot more such memories coming our way to cherish. Just want to let you know that family is what you are and I am extremely proud of all that you have achieved in life. I just want to wish you an extremely happy birthday! Wonderful year ahead, etc etc toh sabne bola hi hoga, so won't repeat it! \uD83D\uDE1B",


            "Happy birthday Dini!! Hope you get all the happiness and success.  Thank you for always being there\uD83D\uDE18❤️This year I hope you carve out more time for your “core group” and spend little less time with your “actual core group” hahahaha!! Love you dini\uD83D\uDE18\uD83D\uDE18",


            "Hey Dinal!! HAPPY BIRTHDAY!!! Hope you’re having a blast and not too bogged down by your favorite incumbent president losing the election :P, hope you improved your basic astronomy knowledge and I hope you keep giving clueless guys fashion advice :D Eat lots of cake and food and have a wonderful year ahead <3",


            "Hi Dinaldi, wish you a very happy birthday. We have always had so many outings together and have so many great memories to cherish including the creation of #coregroup. I have seen you grow professionally and also become an amazing person and friend. Be the way you are. I’m always there for you when you need me. Happy birthday \uD83D\uDE18\uD83E\uDD17",


            "A connection spanning more than 15 years now, you are more like a family than a friend \n" +
                    "Despite the distance and long breaks between chats, we can pick it up right where we left. That’s what we are. \n" +
                    "Comfort, confidence and support is the constant. \n" +
                    "We may not talk every day, but we know one thing for sure... can always count on each other for anything \n" +
                    "\n" +
                    "Happiest Birthday Meow \uD83D\uDE40 to my Rats \uD83D\uDC2D",


            "Happiest Birthday my dearest Dinal ❤️ Wishing you all the happiness in the world. I love you from the bottom of my heart. And I miss you terribly."
    };



    @Override
    public int getCount() {
        return sliderHints.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        final View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        final TextView hintTextView = view.findViewById(R.id.quiz_question);
        final EditText answerView =  view.findViewById(R.id.quiz_answer);
        final ImageView friendImage =  view.findViewById(R.id.friend_image);
        final TextView friendMessage = view.findViewById(R.id.friend_message);
        final Button flipButton =  view.findViewById(R.id.submit_btn);
        final MediaPlayer dilwale = MediaPlayer.create(context,R.raw.dilwale);
        final MediaPlayer cheer = MediaPlayer.create(context,R.raw.cheer);

        final EasyFlipView easyFlipView =  view.findViewById(R.id.easy_flip_view);
        flipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = answerView.getText().toString();
                answer = answer.toLowerCase().trim();
                if(answer.equals(sliderAnswer[position])){
                    Toast.makeText(context, "JE BAAAAAT!", Toast.LENGTH_LONG).show();
                    easyFlipView.flipTheView(true);
                    cheer.start();
                    if (cheer.isPlaying() == false) {
                        cheer.release();
                    }
                }else{
                    Toast.makeText(context,"Friendship compromised!!!!", Toast.LENGTH_LONG).show();
                    dilwale.start();
                    if(dilwale.isPlaying() == false){
                        dilwale.release();
                    }
                }
            }
        });
        final Button flipBack = (Button) view.findViewById(R.id.flip_back);
        flipBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easyFlipView.flipTheView(true);
            }
        });

        hintTextView.setText(sliderHints[position]);
        friendImage.setImageResource(sliderImage[position]);
        friendMessage.setText(sliderMessage[position]);

        container.addView(view);

        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((LinearLayout)object);
    }


}

