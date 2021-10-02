A = imread('gray-3.jpeg');
x_padded = padarray(A, [2 2]);
x1=x_padded(1:256,1:256);
mask = [1 2 3; 4 5 6; 7 8 9]; % chosen mask
mask = mask / sum(mask(:)); % Normalize
y1= uint8(conv2(double(x1),mask, 'same'));
imshow(y1, [])