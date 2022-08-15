## Problem tanımı:
Satranç tahtası üzerinde bulunan taşlara göre iki tarafın (siyah – beyaz) mevcut durumlarının puan
hesaplaması.

###### Açıklama:
Mevcut puanı hesaplama algoritması şöyledir:
1. Bir taşın tehdit altında olup olmadığının kontrolü, o taşı tehdit eden karşı renkte bir veya
   birden fazla taş olması durumunda oluşur.
   
2. Tablo 1 Satranç Taşları ve Puanları ’de taşların puanları verilmiştir. Eğer bir taş tehdit edilmiyorsa tablodaki puanı alır.
   Eğer bir taş karşı tarafın taşlarından herhangi biri tarafından tehdit ediliyorsa, tehdit edilen taşın puanı Tablo 1 Satranç Taşları ve
   Puanlarındaki puanının yarısı alınır.

3. Tüm taşların tehdit durumları kontrol edilir. Siyah ve beyaz taşlar için iki ayrı puan
   hesaplanır.



##### Tablo 1 Satranç Taşları ve Puanları : 

    Taş İsmi       Kısaltma  Puanı
   
       Piyon           p      1
       At              a      3
       Fil             f      3
       Kale            k      5
       Vezir           v      9
       Şah             s     100

---------------------------------------

### board1 :

![](../../../../Desktop/app/board1.png)

ks as fs vs ss fs -- ks

ps ps -- -- ps ps -- ps

-- -- ps -- -- -- -- --

-- -- -- as -- -- ps --

vb -- -- pb -- fb -- pb

-- -- ab -- -- -- -- --

pb pb -- -- pb pb pb --

kb -- -- -- sb fb ab kb


---------------------------------------

### board2 :

![](../../../../Desktop/app/board2.png)

-- as -- vs ss -- -- fs

-- -- -- -- ps -- -- --

-- ab ps -- -- fb ab --

-- -- -- as -- -- -- --

vb -- -- pb pb -- -- --

-- -- -- -- -- -- -- -_

-- -- -- -- -- -- pb --

-- -- -- -- sb -- -- kb

-----------------------------------------------------------


### board3 :

![](../../../../Desktop/app/board3.png)

vb -- -- vs ss -- -- --

-- -- -- -- -- ps -- ps

-- as ps -- pb -- ab --

-- -- -- ab -- -- -- --

-- -- -- -- -- -- -- -_

-- -- -- -- -- -- pb --

-- -- -- -- -- -- -- -_

-- -- -- -- sb -- -- --


------------------------
Sonuclar : 

board1.txt		Siyah:135	Beyaz:134.5

board2.txt		Siyah:116	Beyaz:123

board3.txt		Siyah:108	Beyaz:109
