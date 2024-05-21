import React from 'react';
import defaultPicture from '../../../assets/profile.png';

const ProfileImageWithDefault = (props) => {
  const { image, tempimage, ...otherProps } = props;

  let imageSource = defaultPicture;
  if (image) {
    imageSource = '/images/' + image;
  }

  return (
    <img
      alt={"Profile" }
      src={tempimage || imageSource}
      {...otherProps}
      onError={(event) => {
        event.target.src = defaultPicture;
      }}
    />
  );
};

export default ProfileImageWithDefault;
