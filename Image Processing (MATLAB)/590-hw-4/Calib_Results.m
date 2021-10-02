% Intrinsic and Extrinsic Camera Parameters
%
% This script file can be directly executed under Matlab to recover the camera intrinsic and extrinsic parameters.
% IMPORTANT: This file contains neither the structure of the calibration objects nor the image coordinates of the calibration points.
%            All those complementary variables are saved in the complete matlab data file Calib_Results.mat.
% For more information regarding the calibration model visit http://www.vision.caltech.edu/bouguetj/calib_doc/


%-- Focal length:
fc = [ 3536.165288319809406 ; 3561.712512620331381 ];

%-- Principal point:
cc = [ 1417.179786597108659 ; 2110.118841187111684 ];

%-- Skew coefficient:
alpha_c = 0.000000000000000;

%-- Distortion coefficients:
kc = [ 0.082085097717940 ; -0.184205994644711 ; 0.011428468900914 ; -0.003974569434379 ; 0.000000000000000 ];

%-- Focal length uncertainty:
fc_error = [ 47.969040288604667 ; 45.860109043407199 ];

%-- Principal point uncertainty:
cc_error = [ 67.960528196899133 ; 83.588691017109340 ];

%-- Skew coefficient uncertainty:
alpha_c_error = 0.000000000000000;

%-- Distortion coefficients uncertainty:
kc_error = [ 0.057165324123637 ; 0.180494931028928 ; 0.009273955509000 ; 0.006890311192450 ; 0.000000000000000 ];

%-- Image size:
nx = 3024;
ny = 4032;


%-- Various other variables (may be ignored if you do not use the Matlab Calibration Toolbox):
%-- Those variables are used to control which intrinsic parameters should be optimized

n_ima = 18;						% Number of calibration images
est_fc = [ 1 ; 1 ];					% Estimation indicator of the two focal variables
est_aspect_ratio = 1;				% Estimation indicator of the aspect ratio fc(2)/fc(1)
center_optim = 1;					% Estimation indicator of the principal point
est_alpha = 0;						% Estimation indicator of the skew coefficient
est_dist = [ 1 ; 1 ; 1 ; 1 ; 0 ];	% Estimation indicator of the distortion coefficients


%-- Extrinsic parameters:
%-- The rotation (omc_kk) and the translation (Tc_kk) vectors for every calibration image and their uncertainties

%-- Image #1:
omc_1 = [ 2.140759e+00 ; 2.209824e+00 ; -1.974919e-01 ];
Tc_1  = [ -1.046734e+02 ; -1.528408e+02 ; 4.386540e+02 ];
omc_error_1 = [ 1.990968e-02 ; 2.251428e-02 ; 4.489706e-02 ];
Tc_error_1  = [ 8.561545e+00 ; 1.035630e+01 ; 7.265899e+00 ];

%-- Image #2:
omc_2 = [ 2.574233e+00 ; 7.928347e-01 ; 5.898013e-01 ];
Tc_2  = [ -1.352074e+02 ; 9.724068e+00 ; 3.369762e+02 ];
omc_error_2 = [ 2.547955e-02 ; 1.050740e-02 ; 3.351730e-02 ];
Tc_error_2  = [ 6.726168e+00 ; 8.142680e+00 ; 7.032383e+00 ];

%-- Image #3:
omc_3 = [ 2.477623e+00 ; 1.698969e+00 ; 8.267370e-01 ];
Tc_3  = [ -1.363044e+02 ; -8.523739e+01 ; 3.539834e+02 ];
omc_error_3 = [ 2.393413e-02 ; 1.383512e-02 ; 3.952638e-02 ];
Tc_error_3  = [ 7.347228e+00 ; 8.585639e+00 ; 7.237681e+00 ];

%-- Image #4:
omc_4 = [ -1.883773e+00 ; -1.910875e+00 ; -4.933656e-01 ];
Tc_4  = [ -1.335982e+02 ; -1.599844e+02 ; 3.914485e+02 ];
omc_error_4 = [ 1.919853e-02 ; 2.058580e-02 ; 3.552613e-02 ];
Tc_error_4  = [ 7.951905e+00 ; 9.842026e+00 ; 8.003644e+00 ];

%-- Image #5:
omc_5 = [ -1.809237e+00 ; -1.981989e+00 ; -1.945252e-01 ];
Tc_5  = [ -1.231384e+02 ; -1.749515e+02 ; 4.107337e+02 ];
omc_error_5 = [ 1.934054e-02 ; 1.984449e-02 ; 3.637200e-02 ];
Tc_error_5  = [ 8.232501e+00 ; 1.013792e+01 ; 7.900967e+00 ];

%-- Image #6:
omc_6 = [ -1.322266e+00 ; -1.698797e+00 ; 4.422470e-01 ];
Tc_6  = [ -7.050599e+01 ; -1.878528e+02 ; 4.357932e+02 ];
omc_error_6 = [ 1.958619e-02 ; 1.602135e-02 ; 2.529164e-02 ];
Tc_error_6  = [ 8.750013e+00 ; 1.023464e+01 ; 6.299198e+00 ];

%-- Image #7:
omc_7 = [ -8.961846e-01 ; -2.219580e+00 ; -1.178444e-01 ];
Tc_7  = [ -3.643692e+01 ; -1.940007e+02 ; 3.404626e+02 ];
omc_error_7 = [ 1.409051e-02 ; 1.966307e-02 ; 2.940513e-02 ];
Tc_error_7  = [ 6.975444e+00 ; 8.243478e+00 ; 6.423365e+00 ];

%-- Image #8:
omc_8 = [ 2.443864e+00 ; 9.938074e-01 ; -7.418869e-01 ];
Tc_8  = [ -1.250888e+02 ; 4.231023e+01 ; 5.387927e+02 ];
omc_error_8 = [ 2.539493e-02 ; 1.700762e-02 ; 3.337762e-02 ];
Tc_error_8  = [ 1.040292e+01 ; 1.256464e+01 ; 8.374326e+00 ];

%-- Image #9:
omc_9 = [ 2.725947e+00 ; 8.607550e-01 ; -1.144640e+00 ];
Tc_9  = [ -1.051709e+02 ; 4.315495e+01 ; 5.452034e+02 ];
omc_error_9 = [ 2.318294e-02 ; 1.929307e-02 ; 3.396921e-02 ];
Tc_error_9  = [ 1.057122e+01 ; 1.267539e+01 ; 7.028515e+00 ];

%-- Image #10:
omc_10 = [ -1.208672e+00 ; -1.743300e+00 ; 4.776479e-01 ];
Tc_10  = [ -1.250084e+01 ; -1.737648e+02 ; 4.366539e+02 ];
omc_error_10 = [ 1.933342e-02 ; 1.728423e-02 ; 2.596760e-02 ];
Tc_error_10  = [ 8.684559e+00 ; 1.028905e+01 ; 6.476853e+00 ];

%-- Image #11:
omc_11 = [ -1.404635e+00 ; -1.853601e+00 ; 2.158122e-01 ];
Tc_11  = [ -5.129944e+01 ; -1.908496e+02 ; 4.245116e+02 ];
omc_error_11 = [ 1.932558e-02 ; 1.697261e-02 ; 2.862994e-02 ];
Tc_error_11  = [ 8.539226e+00 ; 1.009641e+01 ; 7.082810e+00 ];

%-- Image #12:
omc_12 = [ -1.978043e+00 ; -2.050417e+00 ; -3.305956e-01 ];
Tc_12  = [ -8.681547e+01 ; -1.363195e+02 ; 3.098841e+02 ];
omc_error_12 = [ 1.630813e-02 ; 1.858940e-02 ; 3.459097e-02 ];
Tc_error_12  = [ 6.272860e+00 ; 7.599192e+00 ; 6.067842e+00 ];

%-- Image #13:
omc_13 = [ 2.211070e+00 ; 2.011327e+00 ; 8.881957e-01 ];
Tc_13  = [ -1.151865e+02 ; -1.246599e+02 ; 2.871893e+02 ];
omc_error_13 = [ 2.079944e-02 ; 1.464118e-02 ; 3.634257e-02 ];
Tc_error_13  = [ 6.110998e+00 ; 7.212338e+00 ; 6.204068e+00 ];

%-- Image #14:
omc_14 = [ 1.434563e+00 ; 2.465312e+00 ; 4.591896e-01 ];
Tc_14  = [ -2.370144e+01 ; -1.915183e+02 ; 3.992402e+02 ];
omc_error_14 = [ 1.655556e-02 ; 2.238732e-02 ; 3.971992e-02 ];
Tc_error_14  = [ 8.090892e+00 ; 9.578513e+00 ; 7.330639e+00 ];

%-- Image #15:
omc_15 = [ 1.229593e+00 ; 2.516439e+00 ; 1.015761e+00 ];
Tc_15  = [ 1.817729e+01 ; -1.616455e+02 ; 3.433380e+02 ];
omc_error_15 = [ 1.741148e-02 ; 1.856820e-02 ; 3.678600e-02 ];
Tc_error_15  = [ 6.936256e+00 ; 8.357819e+00 ; 6.849675e+00 ];

%-- Image #16:
omc_16 = [ 1.937830e+00 ; 1.507199e+00 ; 1.123992e+00 ];
Tc_16  = [ -1.151098e+02 ; -1.146612e+02 ; 3.193659e+02 ];
omc_error_16 = [ 2.288648e-02 ; 1.511414e-02 ; 2.987332e-02 ];
Tc_error_16  = [ 6.690577e+00 ; 7.846674e+00 ; 6.711537e+00 ];

%-- Image #17:
omc_17 = [ 2.170560e+00 ; 1.815734e+00 ; 9.084646e-01 ];
Tc_17  = [ -1.227678e+02 ; -1.215465e+02 ; 3.424601e+02 ];
omc_error_17 = [ 2.264919e-02 ; 1.561499e-02 ; 3.626818e-02 ];
Tc_error_17  = [ 7.171033e+00 ; 8.426258e+00 ; 7.120667e+00 ];

%-- Image #18:
omc_18 = [ -1.611654e+00 ; -1.560025e+00 ; -8.738570e-01 ];
Tc_18  = [ -9.113960e+01 ; -1.088211e+02 ; 3.171743e+02 ];
omc_error_18 = [ 1.731375e-02 ; 2.078209e-02 ; 2.585397e-02 ];
Tc_error_18  = [ 6.356646e+00 ; 7.819474e+00 ; 6.410882e+00 ];

