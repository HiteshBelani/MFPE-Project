import React, { useState } from "react";

const ProductIdDialog = () => {
  const [isOpen, setIsOpen] = useState(false);

  const handleOpen = () => {
    setIsOpen(true);
  };

  const handleClose = () => {
    setIsOpen(false);
  };

  return (
    <>
      <button onClick={handleOpen}>Show Dialog</button>
      {isOpen && (
        <div className="dialog">
          <p>This is the product id dialog</p>
          <button onClick={handleClose}>Close</button>
        </div>
      )}
    </>
  );
};

export default ProductIdDialog;
