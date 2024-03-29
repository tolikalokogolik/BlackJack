# BlackJack

Autorid: 
* Natali Atamanova 
* Gleb Maksimov

## Kirjeldus

Programm kuvab mängu BlackJack reeglid, mille järel algab kohe ka mäng. 
Diilerid on kaks kaarti, millest üks on mängijale nähtav. Samuti mängijale on nähtavad tema kaks kaarti.
Edasi on mängijal kaks võimalikku valikut mida teha:
 
 1. Võtta kaardi juurde (hit)
 2. Lõpetada oma käiguringi (pass)
 
 Esimese puhul, saab mängija järgmise kaardi eelnevalt segatud kaardipakist. 
 Kui mängija kaartide punktisumma ületab 21 punkti, siis on mängija automaatselt kaotanud. 
 Kui aga punktisumma on võrdne 21-ga, siis on mängija automaatselt võitnud.
 
 Teise valiku saab mängija teha ainult juhul, kui tal on alla 21 punkti, siis käik läheb üle diilerile.
 Diileril on suhteliselt lihtne AI:
 
 * Diileri punktisumma <= 11 -> Diiler võtab uue kaardi (hit)
 * 11 < Diileri punktisumma <= 16 -> Tõenäosusega 1/3 diiler võtab uue kaardi ning tõenäosusega 2/3 lõpetab oma käigu
 * 16 < Diileri punktisumma -> Diiler lõpetab oma käigu
 
 Kui mängija ega diiler pole automaatselt võitnud või kaotanud, siis arvestatakse võidu suurima punktisumma järgi.
 
Punktid on vastavad :

* 2-10: annavad samapalju punkte, kui number kaartidel
* J, Q, K: annavad 10 punkti
* A: 11 või 1 punkt. 11, kui kaardtide summa on alla või võrdne 21 punktiga, ning 1, kui kaartide summa on üle 21 punkti.

## Klassid

### Card

Defineerib ühe kaardi ja temale vastava masti ning järgu.

Tähtsaim meetod:

* public String getRank()

Kuna mängus ei oma suurt tähtsust mast, siis rank osutub rätsamaks punktisumma arvutamisel.

### CardHolder

Kaardipakk, mis võib olla kas tühi, või omada n erinevat kaardipakki,  n $\in$ N.
Mängija ja diileri kaardid käes on vastavalt alguses tühjad kaardipakid, ning mängu käigus täituvad. 
Defineeritakse ka mängu kaardipaki, kust mängija ja diiler kaardid võtavad.

Tähtsamad meetodid:

* public CardHolder(int n) - konstruktor
* public void shuffle() - kaardipaki segamine
* public Card takeCard() - kaardi võtmine kaardipakist
* public void addCard(Card card) - kaardi lisamine kaardipakki

### Hooman

Ülemklass klassidele mängija ja diiler. Defineerib meetodid, mis on samad diileril ja mängijal.

Tähtsamad meetodid:

* public void hit(Card card) - võtab kaardi juurde
* public int calculatePoints() - arvutab punktisumma vastavalt varem mainitud loogikale
* public CardHolder getCardsOnHand() - tagastab kaardipaki

### Player

Nimi räägib iseenda eest.

Tähtsamad meetodid:

* public void showStatus() - prindib mängija hetkel olevad kaardid
* public String whatToDoNext() - küsib ja kontrollib mängija järgmise tegevuse

### Dealer

Diileriga seotud funktsioonid, mis natuke erinevad mägijast.

Tähtsamad funktsioonid:

* public void hit(Card card) @Override - võtab kaardi juurde, kuid kui tegemist on esimese kaardiga, siis jätab selle meelde. Iga lisaks võetud kaardi kohta antakse teade mängijale.
* public void showFirstCard() - prindib teate diileri esimesest kaardist.

### BlackJack

Sisaldab kõiki põhiteateid ja tegevusi seoses mänguga.

Tähtsamad funktsioonid:

* private void dealerTurns() - paneb jooksma m+ägija käikude while tsükkli
* private void playerTurns() - paneb jooksma diileri käikude while tsükkli
* public void start() - käivitab kogu mängu

### Stats

Võitude ja kaotuste statistika klass. Kui mängija vastab failis salvestatud nimele, siis lisab uue statistika juurde, vastasel juhul alustab loendamist nullist. Statistika on failis "stats.txt". Kui fail puudub, siis fail luuakse.

Tähtsamad funktsioonid:

* public Stats() - konstruktor, kus toimub kogu info sisselugemine
* public void saveStats() - andmete salvestus

### Main - peaklass

Mängu käivitamiseks.

## Projekti tegemise protsess

1. Arutelu ligikaudse struktuuri üle (vajalikud funktsioonid, klassid) - koos.
2. Baasi loomine : kõik klassid ilma või minimaalse sisuga + sisu kaartide ja kaardipaki jaoks - Gleb.
3. Ülejäänud sisu loomine - Natali.
4. Debugging + koodi puhastamine - Natali.
5. Viimistlus - koos (vajaliku teksti kirjutamine jms).

Mõlemad raiskasid umbes 2-3 päeva projekti tegemisele.
Ei tundnud puudusi teadmistest, võib olla debugging oli natuke häiriv, nagu ikka progemises.

Võiks kuidagi ilusamat moodi kirjutada klassi BlackJack.

Peamiseks test-meetodiks oli igal pool sout toppimine ja järgiuurimine, miks väljund erineb oodatud väljundist.
Üks bug näide: klassis Dealer oli omakorda loodud kaardipakk, mistõttu kui küsisid kaardipaki suurust, said tagasi 0, kui aga jooksid elemendid üle - kõik oli kohal.
