import BasicLayout from './BasicLayout'

function Index(props) {
  return (
    <BasicLayout>
      { props.children }
    </BasicLayout>
  );
}

export default Index;
