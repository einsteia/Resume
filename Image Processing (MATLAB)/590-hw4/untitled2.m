a = imread('4.jpg');
figure
subplot(2,2,1)
imshow(a); title('Original Image');

a = imread('4thresh.jpg');
a = uint8(a);
subplot(2,2,2)
imshow(a); title('Threshold Image');

a = rgb2gray(a);
a = double(a);
fImage = zeros(size(a));
  
% Sobel Operator Mask
Mx = [-1 0 1; -2 0 2; -1 0 1];
My = [-1 -2 -1; 0 0 0; 1 2 1];

for i = 1:size(a, 1) - 2
    for j = 1:size(a, 2) - 2
        
        Gx = sum(sum(Mx.*a(i:i+2, j:j+2)));
        Gy = sum(sum(My.*a(i:i+2, j:j+2)));

        fImage(i+1, j+1) = sqrt(Gx.^2 + Gy.^2);
    end
end

fImage = uint8(fImage);
subplot(2,2,[3,4])
imshow(fImage); title('Filtered Image');

outImage = im2bw(fImage);

% Hough transform
[H, theta, rho] = hough(outImage);
figure
subplot(2,1,1), imshow(imadjust(rescale(H)),'XData',theta,'YData',rho,'InitialMagnification', 'fit'); title('Hough Transform');
axis on
axis normal
hold on;
colormap(gca, hot);

A = houghpeaks(H,10,'threshold',ceil(0.2*max(H(:))));

lines = houghlines(outImage,theta,rho,A,'FillGap',10,'MinLength',9);
subplot(2,1,2), imshow(outImage); title('Edge Detected Image');
hold on
max_len = 0;
for k = 1:length(lines)
    xy = [lines(k).point1; lines(k).point2];
    plot(xy(:,1),xy(:,2),'LineWidth',2, 'Color', 'green');
end
