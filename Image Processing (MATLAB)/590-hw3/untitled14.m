B=imread('gray-2.jpeg');

grayscale = rgb2gray (B);

k1 = [ -1 0 1; -2 0 2; -1 0 1];
k2 = [1 2 1; 0 0 0; -1 -2 -1];

I=double(B);
In=I;
  
k3=[0, -1, -1; 1, 0, -1;1, 1, 0];
k4=[1, 1, 1;0, 0, 0;-1, -1, -1];
k4=rot90(k3,2);
mask=rot90(k4,2);
  
input = rgb2gray(B);
input = im2bw(input);
input = double(input);
C = zeros(size(input));

k5 = [-1 0 1; -2 0 2; -1 0 1];
k6 = [-1 -2 -1; 0 0 0; 1 2 1];

for i = 1:size(input, 1) - 2
    for j = 1:size(input, 2) - 2
  
        G1 = sum(sum(k5.*input(i:i+2, j:j+2)));
        G2 = sum(sum(k6.*input(i:i+2, j:j+2)));
                 
        C (i+1, j+1) = sqrt(G1.^2 + G2.^2);    
    end
end
subplot(2,2,2)
imshow(C);

if rem(length(k1), 2) == 1
    if rem(length(k2), 2) == 1
        M1 = conv2 (double(grayscale),double(k1)) ;
        M2 = conv2 (double(grayscale),double(k2)) ;
    
        subplot(2,2,3)
        imshow (( M1 .^2+ M2 .^2) .^0.5 , []) ;
else
        disp('kernerl dimensions are NOT odd');
    end
end

f = im2double(imread('gray-2.jpeg'));
gray = rgb2gray (f) ;
k7 = [ 2 2 -1 ; 1 2 1 ; 1 2 1 ] / 9;
h = conv2(gray, k7);
subplot(2,2,1)
imshow(h);

k8 = [ -1 -1 0 ; -1 3 0 ; 0 0 0 ];
subplot(2,2,4)
imshow(conv2(gray, k8) + 0.6);