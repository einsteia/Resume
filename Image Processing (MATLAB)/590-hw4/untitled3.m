function untitled3
B=imread('3.jpg');
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
threshval = (val-1)/256;

thresh = im2bw(B,threshval);

figure,
imshow(thresh);
title('Threshold Image');

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
