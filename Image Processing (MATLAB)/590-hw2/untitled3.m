img = imread("pumpkin.jpg");
subplot(2,2,1)
imshow(img);
title('Original Image');

img3 = immultiply(img, 50)
subplot(2,2,2)
imshow(img3)
title('Multiply Scalar');

img4 = imdivide(img, 50)
subplot(2,2,3)
imshow(img4)
title('Divide Scalar');

img5 = imcompliment(img)
subplot(2,2,4)
imshow(img5)
title('Compliment Image');


