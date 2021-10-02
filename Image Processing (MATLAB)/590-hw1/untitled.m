rgbImage = imread('590-HW1-P3.jpg')
hsv = rgb2hsv(rgbImage);
h = hsv(:, :, 1); 
subplot(2,2,1)
imshow(h);
title('Hue');

s = hsv(:, :, 2); 
subplot(2,2,2)
imshow(s);
title('Saturation');

v = hsv(:, :, 3); 
subplot(2,2,3)
imshow(s);
title('Intensity');