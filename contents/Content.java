package contents;

import enums.tipKomponenti.TipSadrzaja;

public class Content {
    private String text;
    private String urlSlike;

    public Content(String arg, TipSadrzaja tipSadrzaja) {
        if(tipSadrzaja.equals(TipSadrzaja.TEKST)) text = arg;
        else if(tipSadrzaja.equals(TipSadrzaja.SLIKA)) urlSlike = arg;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrlSlike() {
        return urlSlike;
    }

    public void setUrlSlike(String urlSlike) {
        this.urlSlike = urlSlike;
    }

    public String myFormat() {
        String[] izbaci = {"/", "*", "~", "_"};
        StringBuilder builder = new StringBuilder(text);
        for(int i = 0; i < izbaci.length; i++) {
            int index = builder.indexOf(izbaci[i]);
            while (index != -1) {
                builder.replace(index, index + izbaci[i].length(), "");
                index += izbaci[i].length(); // Move to the end of the replacement
                index = builder.indexOf(izbaci[i], index);
            }
        }
        return builder.toString();
    }
}
