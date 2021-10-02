I = imread('lighthouse.jpg');
subplot(2,2,1);
imshow(I)
A = imrotate(I,20);


tform2 = randomAffine2d('Rotation',[-45 10]);
A2 = imwarp(I,tform2);

subplot(2,2,2);
imshow(A);

subplot(2,2,3);
imshow(A2);

subplot(2,2,4);
imshowpair(A,A2);

