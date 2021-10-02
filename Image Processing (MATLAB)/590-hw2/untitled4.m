A = imread('mountains.jpg');
subplot(2,2,1);
imshow(A);
title('First Image');
b=size(A);

B = imread('purpleGalaxy.jpg');
B=imresize(B,[b(1),b(2)]);
subplot(2,2,2);
imshow(B);
title('Second Image Resized');


subplot(2,2,3);
imshow(B);
title('Second Image Resized with reduced Scalar');
for i = 1:b(1)
 for j = 1:b(2)
     for k=1:3
 output(i,j,k)=(A(i,j,k)+B(i,j,k));
     end
 end
end
figure
imshow(output);
title('Combined Images');