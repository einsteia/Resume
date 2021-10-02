A = imread("lighthouse.jpg");

subplot(2,2,1)
imshow(A);
title('Original Image');

R=rot90(A(:,:,1),1);
G=rot90(A(:,:,2),1);
B=rot90(A(:,:,3),1);
D(:,:,1)=rot90(A(:,:,1),1);
D(:,:,2)=rot90(A(:,:,2),1);
D(:,:,3)=rot90(A(:,:,3),1);
subplot(2,2,2)
imshow(D);
title('90 Degree Rotation');

theta = 30;
Img3 = imrotate(A,theta);
subplot(2,2,3)
imshow(Img3);
title('Vayring Theta angle');
