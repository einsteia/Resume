function untitled4

B=imread('gray-5.jpeg');
V1=hist(B,0:255);
G=reshape(V1,[],1);

Ind=0:255;
I1=reshape(Ind,[],1);
res=zeros(size([1 256]));




for A=0:255
    [weightb,varb]=calculate(1,A);
    [weightf,varf]=calculate(A+1,255);
    res(A+1)=(weightb*varb)+(weightf*varf);
end

[~,val]=min(res);
threshval = (val-1)/256

bin = im2bw(B,threshval);
subplot(2,2,1)
imshow(B);
title('Grayscale Image');

subplot(2,2,3);
imshow(bin);
title('Threshold Image');
xlabel({'Threshold Value',threshval})

subplot(2,2,4);
imhist(B);
title('Histogram (Library)');

Size = size(B);
Bd = 8;
Histo = zeros(1,(2^(Bd)));
for i=1:Size(1)
    for j=1:Size(2)
        Temp = B(i,j);
        Histo(Temp+1) = Histo(Temp+1) + 1;
    end
end

subplot(2,2,2)
bar(0:(2^(Bd) -1),Histo)
title('Histogram');

function [weight,variance]=calculate(m,n)

weight=sum(G(m:n))/sum(G);

v=G(m:n).*I1(m:n);
total=sum(v);
mean=total/sum(G(m:n));

val2=(I1(m:n)-mean).^2;
num=sum(val2.*G(m:n));
variance=num/sum(G(m:n));

end
end
