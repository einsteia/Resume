BW = imread("Congaree.png");
subplot(2, 2, 1);
imshow(BW, []);
title('Original Image');

gray = BW;
level = graythresh(gray);
binaryImage = im2bw(gray, level);

BWS = bwmorph(binaryImage,'skel',Inf);
subplot(2,2,2)
imshow(BWS)
title('Skeleton');
axis on;

subplot(2, 2, 3);
imshow(BW, []);
title('Image with Axis');
axis on;

subplot(2, 2, 4);
imshow(BW, []);
title('Boundaries with Axis');
axis on;

boundaries = bwboundaries(binaryImage);
numberOfBoundaries = size(boundaries, 2);
for Idx = 1 : numberOfBoundaries
	thisBoundary = boundaries{Idx};
	x = thisBoundary(:, 2); 
	y = thisBoundary(:, 1);
	
	maxDistance = -inf;
	for k = 1 : length(x)
		distances = sqrt( (x(k) - x) .^ 2 + (y(k) - y) .^ 2 );
		[thisMaxDistance, indexOfMaxDistance] = max(distances);
		if thisMaxDistance > maxDistance
			maxDistance = thisMaxDistance;
			index1 = k;
			index2 = indexOfMaxDistance;
		end
	end
	
	subplot(2, 2, 3);
	line([x(index1), x(index2)], [y(index1), y(index2)], 'Color', 'r', 'LineWidth', 3);
	line([cx(firstIndex), cx(lastIndex)], [cy(firstIndex), cy(lastIndex)], 'Color', 'm', 'LineWidth', 3);
    
    subplot(2, 2, 4);
    plot(x, y, 'y-', 'LineWidth', 3);
	line([x(index1), x(index2)], [y(index1), y(index2)], 'Color', 'r', 'LineWidth', 3);
	line([cx(firstIndex), cx(lastIndex)], [cy(firstIndex), cy(lastIndex)], 'Color', 'm', 'LineWidth', 3);
	
end

