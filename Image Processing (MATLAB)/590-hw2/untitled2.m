img = imread("pumpkin.jpg");
subplot(2,2,1)
imshow(img);
title('Original Image');

blurImg = imgaussfilt(img,8);
subplot(2,2,2)
imshow(blurImg);
title('Blurred Image');

img1 = imadd(img,100);
subplot(2,2,3)
imshow(img1)
title('Added Scalar');

img2 = imsubtract(img,130);
subplot(2,2,4)
imshow(img2)
title('Subtracted Scalar');

