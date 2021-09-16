import React, { useState } from "react";
import { Link } from "react-router-dom";
import {
  Paper,
  List,
  Card,
  Typography,
  Menu,
  MenuItem,
  makeStyles,
} from "@material-ui/core";
import { useSelector, useDispatch } from "react-redux";

import { cartActions } from "../../store/cartSlice";
import Offer from "../../shared/offers/Offer";

const useStyles = makeStyles((theme) => ({
  cartContainer: {
    width: "100%",
    padding: 10,
  },
  title: {
    textAlign: "center",
    margin: "20px 0",
  },
  list: {
    display: "grid",
    gridTemplateColumns: "repeat(auto-fit, minmax(300px, 400px))",
    columnGap: theme.spacing(1),
    rowGap: theme.spacing(2),
    margin: "0 auto",
    width: "100%",
    justifyContent: "center",
  },
  card: {
    width: "60%",
    minWidth: 300,
    padding: "10px 20px",
    margin: "0 auto",
  },
}));

const Cart = (props) => {
  const styles = useStyles();

  const dispatch = useDispatch();
  const cart = useSelector((state) => state.cart);

  const [anchorEl, setAnchorEl] = useState(null);
  const [id, setId] = useState(null);

  const openMenuHandler = (event, id) => {
    console.log(id);
    setAnchorEl(event.currentTarget);
    setId(id);
  };

  const closeMenuHandler = () => {
    setAnchorEl(null);
    setId(null);
  };

  const removeFromCartHandler = () => {
    dispatch(cartActions.removeFromCart(id));
    closeMenuHandler();
  };

  if (cart.offers.length < 1) {
    return (
      <Card
        className={styles.card}
        style={{ textAlign: "center" }}
        elevation={3}
      >
        <Typography component="h1" variant="h5">
          Wygląda na to, że Twój koszyk jest pusty.
        </Typography>
        <Typography component="p">
          <Link to="/">Dodajmy coś do niego!</Link>
        </Typography>
      </Card>
    );
  }

  return (
    // <Paper className={styles.cartContainer} elevation={4}>
    <>
      <Typography className={styles.title} component="h1" variant="h4">
        Mój koszyk
      </Typography>
      <List className={styles.list}>
        {cart.offers.map((item) => (
          <Offer key={item.id} openMenu={openMenuHandler} {...item} />
        ))}
      </List>
      <Typography className={styles.title} component="p" variant="h5">
        Cena całkowita: {cart.totalPrice.toFixed(2)}zł
      </Typography>
      <Menu
        id="simple-menu"
        anchorEl={anchorEl}
        keepMounted
        open={Boolean(anchorEl)}
        onClose={closeMenuHandler}
      >
        <MenuItem onClick={removeFromCartHandler}>Usuń</MenuItem>
      </Menu>
    </>
    /* </Paper> */
  );
};

export default Cart;
