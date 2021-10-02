B=imread('gray-5.jpeg');

g = rgb2gray (B);

k1 = [1 2 3; 4 5 6; 7 8 9];
k2 = [1 2 3; 4 5 6; 7 8 9];
I=double(B);
In=I;
  
mask= [1 2 3; 4 5 6; 7 8 9];
mask2= [1 2 3; 4 5 6; 7 8 9];
mask=rot90(mask,2);
mask=rot90(mask,2);
  
input = rgb2gray(B);
input = im2bw(input);
input = double(input);
C = zeros(size(input));

k3 = [1 2 3; 4 5 6; 0 0 0];
k4 = [1 2 3; 4 5 6; 0 0 0];

for i = 1:size(input, 1) - 2
    for j = 1:size(input, 2) - 2
  
        G1 = sum(sum(k3.*input(i:i+2, j:j+2)));
        G2 = sum(sum(k4.*input(i:i+2, j:j+2)));
                 
        C (i+1, j+1) = sqrt(G1.^2 + G2.^2);    
    end
end
subplot(2,2,2)
imshow(C);

if rem(length(k1), 2) == 1
    if rem(length(k2), 2) == 1
        M1 = conv2 (double(g),double(k1)) ;
        M2 = conv2 (double(g),double(k2)) ;
    
        subplot(2,2,3)
        imshow (( M1 .^2+ M2 .^2) .^0.5 , []) ;
else
        disp('kernerl dimensions are NOT odd');
    end
end

f = im2double(imread('gray-5.jpeg'));
gray = rgb2gray (f) ;
k5 = [1 2 3; 4 5 6; 7 8 9] / 9;
h = conv2(gray, k5);
subplot(2,2,1)
imshow(h);

k6 = [1 2 3; 4 5 6;0 0 0];
subplot(2,2,4)
imshow(conv2(gray, k6) - 0.5);