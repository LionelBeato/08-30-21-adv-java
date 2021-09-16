export type GitHubSearchResultType = {
  total_count: number;
  incomplete_results: boolean;
  // we can use the any type below to accept any kind
  // of elements in our array, but this is discouraged
  // and sometimes considered illegal
  // Items: Array<any>;
  items: Array<GitHubRepository>;
};

export type GitHubRepository = {
  id: string;
  full_name: string;
  html_url: string;
};
