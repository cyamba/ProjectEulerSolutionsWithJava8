fibbo = 0 : 1 : zipWith (+) fibbo (tail fibbo)
takeFibbos n = take n fibbo

--euler2 = sum[ n | n <- [n | n <- take 100 fibbo], n `mod` 2 == 0, n<=4000000 ]
euler2 = sum[ n | n <- [n | n <- take 34 (0 : 1 : zipWith (+) fibbo (tail fibbo))],even n, n<=4000000 ]
